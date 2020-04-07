package DatabaseAcces;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Connection.ConnectionFactory;

public class allDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(allDAO.class.getName());
	private final Class<T> type;
	@SuppressWarnings("unchecked")
	public allDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	private String createDeleteQuery(String id)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE ");
		sb.append("FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE ");
		if(type.getSimpleName().equalsIgnoreCase("Clienti"))
			sb.append("idClienti= ");
				else if(type.getSimpleName().equalsIgnoreCase("Produse"))
					sb.append("idproduse= ");
					else if(type.getSimpleName().equalsIgnoreCase("Comenzi"))
						sb.append("idComenzi= ");
		sb.append(id);
		return sb.toString();
	}
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" * ");
		sb.append("FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + "=?;");
		return sb.toString();
	}
	private String createUpdateQuery(ArrayList<String> valori,String id) 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(type.getSimpleName());
		sb.append(" SET ");
		Field[] a=type.getDeclaredFields();
		int i=0;
		for(Field a1:a)
		{	
			if(i==0) sb.append(a1.getName()+"="+valori.get(i)+",");
			else {
				sb.append(a1.getName()+"="+'"'+valori.get(i)+'"'+",");
			}
			i++;
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(" WHERE ");
		if(type.getSimpleName().equalsIgnoreCase("Clienti"))
			sb.append("idClienti= ");
				else if(type.getSimpleName().equalsIgnoreCase("Produse"))
					sb.append("idproduse= ");
					else if(type.getSimpleName().equalsIgnoreCase("Comenzi"))
						sb.append("idComenzi= ");
		sb.append(id);
		return sb.toString();
	}
	private String createInsertQuery(String valori) {
		Field[] a=type.getDeclaredFields();
		String fielduri="";
		int i=0;
		for(Field a1:a)
		{	if(i==0) i=1;
			else {
			fielduri+=a1.getName()+",";
			i++;
			}
		}
		fielduri = fielduri.substring(0, fielduri.length() - 1);// pentru ultima virgula
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT ");
		sb.append("INTO ");
		sb.append(type.getSimpleName()+" (");
		sb.append(fielduri+")");
		sb.append(" VALUES (");
		sb.append(valori+");");
		return sb.toString();
	}

	

	public List<T> findAll() {
	String sb="SELECT * FROM "+type.getSimpleName();
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.prepareStatement(sb);
		resultSet = statement.executeQuery();
		return (List<T>) createObjects(resultSet);
	} catch (SQLException e) {
		LOGGER.log(Level.WARNING, type.getName() + "DAO:findALL " + e.getMessage());
	} finally {
		ConnectionFactory.close(resultSet);
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}
	return null;
	}
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query=null;
		if(type.getSimpleName().equalsIgnoreCase("Clienti"))
		query = createSelectQuery("idClienti");
		else if(type.getSimpleName().equalsIgnoreCase("Produse"))
		query = createSelectQuery("idproduse");
		else if(type.getSimpleName().equalsIgnoreCase("Comenzi"))
		query = createSelectQuery("idComenzi");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);		
			statement.setInt(1, id); 
			resultSet = statement.executeQuery();			
			List<T> a=createObjects(resultSet);
			if(a.size()==0)
				return null;	
			else 
				return a.get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();
		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance,(Object)value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("null")
	public String insert(String valori) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query=null;
	try {
			connection = ConnectionFactory.getConnection();
			query=this.createInsertQuery(valori);
			statement = connection.prepareStatement(query);
			System.out.println(statement.toString());
			int a=statement.executeUpdate();
			return "Inserarea cu succes!";			
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		return "Inserarea a esuat!";
	} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public String update(ArrayList<String> valori,String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query=null;
	try {
			connection = ConnectionFactory.getConnection();
			query=this.createUpdateQuery(valori,id);
			statement = connection.prepareStatement(query);
			System.out.println(statement.toString());
			int a=statement.executeUpdate();
			return "Update cu succes!";			
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		return "Update a esuat!";
	} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public String delete(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query=null;
	try {
			connection = ConnectionFactory.getConnection();
			query=this.createDeleteQuery(id);
			statement = connection.prepareStatement(query);
			System.out.println(statement.toString());
			int a=statement.executeUpdate();
			return "Delete cu succes!";			
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		return "Delete a esuat!";
	} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public DefaultTableModel createTabel(List<T> afisare) {
		Field[] a=type.getDeclaredFields();
		String[] primaColoana = new String[a.length] ;
		int i=0;
		while(i!=a.length)
		{	
			a[i].setAccessible(true);
			primaColoana[i]=a[i].getName();
			i++;
		}// in sirul de stringuri primaColoana am salvat numele coloanelor, adica prima linie din tabel
		DefaultTableModel tabelModel= new DefaultTableModel();
		tabelModel.setColumnIdentifiers(primaColoana);
		if (afisare == null) {
		return tabelModel;
		}// daca lista de clienti este goala, atunci se creeaza un tabel care contine doar capul de tabel
		i=0;
		int j=0;
		Object[] obiecte = new Object[afisare.size()+1];
		while(i!=afisare.size())
		{
			for(Field as:a)
			{	
			as.setAccessible(true);
			T obiectulExtras =afisare.get(i);
			try {
				obiecte[j] =as.get(obiectulExtras);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}j++;
		}
		tabelModel.addRow(obiecte);
		j=0;
		i++;
		}
		return tabelModel;
	}

}
