package Start;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static ArrayList<MonitoredData> populare()
	{	Stream<String> list;
		ArrayList<MonitoredData> lista=new ArrayList<MonitoredData>();	
		try {
			list = Files.lines(Paths.get("\\PT2019\\pt2019_30227_stroia_lucian_assigment_5\\Assigment5\\Activities.txt"));
			list
		.forEach(line ->{MonitoredData aux=new MonitoredData(); 
		aux.setStart_time(line.split("		")[0]);
		aux.setEnd_time(line.split("		")[1]);
		aux.setAction(line.split("		")[2]);
		lista.add(aux);
		});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public static long two(ArrayList<MonitoredData> lista)
	{
		long nr = 0;
		nr=lista .stream()
				.map(x -> x.getStart_time().substring(8, 10))
				.distinct()
				.count();
		return nr;
	}
	public static Map<String,Long> three(ArrayList<MonitoredData> lista)
	{	Map<String,Long>raspuns=lista.stream()
		.collect(Collectors.groupingBy((line -> line.getAction()),Collectors.counting()));		
		return raspuns;
	}
	public static Stream<Entry<String, Long>> four(ArrayList<MonitoredData> lista)
	{	Map<String, Long> raspuns=
		lista.stream()
		.collect(Collectors.groupingBy(line -> "In ziua de "+line.getStart_time().substring(8,10)+" luna a "+line.getStart_time().substring(5,7)+"-a, activitatea "+line.getAction().trim(),Collectors.counting()))	;
	
	Stream<Entry<String, Long>> sortedMap = raspuns.entrySet().stream()
        .sorted(Entry.comparingByValue());
   		return sortedMap;
	}
	public static String five1(String data1, String data2)
	{	DateFormat f= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1;
		Date d2;
		try {
			d1=f.parse(data1);
			d2=f.parse(data2);
			long raspuns2=d2.getTime()-d1.getTime();
			long raspuns=Math.abs(TimeUnit.SECONDS.convert(raspuns2, TimeUnit.MILLISECONDS));
			long ho=raspuns / 3600;
			String hours =ho +"";
			long mi=(raspuns % 3600) / 60;
			String minutes = mi+"";
			long se=raspuns % 60;
			String seconds = se+"";
			return hours+":"+minutes+":"+seconds;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static long six1(String data1, String data2)
	{	DateFormat f= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1;
		Date d2;
		try {
			d1=f.parse(data1);
			d2=f.parse(data2);
			long raspuns2=d2.getTime()-d1.getTime();
			long raspuns=Math.abs(TimeUnit.SECONDS.convert(raspuns2, TimeUnit.MILLISECONDS));
			return raspuns;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static 	List<String> five2(ArrayList<MonitoredData> lista)
	{	
		List<String> raspuns=lista.stream()
				.map(line ->"Activitatea "+line.getAction().trim()+" incepe in:"+line.getStart_time()+", se sfarseste in:"+line.getEnd_time()+" si dureaza: "+five1(line.getStart_time(), line.getEnd_time()))
				.collect(Collectors.toList());
	
		///Map<String,Long> raspuns=lista.stream()
		//.collect(Collectors.groupingBy(line ->"Activitatea "+line.getAction().trim()+" incepe in:"+line.getStart_time()+", se sfarseste in:"+line.getEnd_time(),Collectors.summingLong(x -> five1(x.getStart_time(),x.getEnd_time()))))	;
		return raspuns;
	}
	public static 	Map<String,Long> six2(ArrayList<MonitoredData> lista)
	{	Map<String,Long> raspuns=lista.stream()
		.collect(Collectors.groupingBy(line ->line.getAction().trim(),Collectors.summingLong(x -> six1(x.getStart_time(),x.getEnd_time()))))	;
		return raspuns;
	}
	public static ArrayList<String> seven(ArrayList<MonitoredData> lista)
	{
		Map<String,Long> raspuns1=lista.stream()
				.collect(Collectors.groupingBy(line ->"Activitatea "+line.getAction().trim(),Collectors.counting()));
		
		Map<String,Long> raspuns2=lista.stream()
				.filter(x -> six1(x.getStart_time(),x.getEnd_time())<=5*60)
				.collect(Collectors.groupingBy(line ->"Activitatea "+line.getAction().trim(),Collectors.counting()));
		
		ArrayList<String> raspunsFinal=(ArrayList<String>) raspuns2.entrySet().stream()
				.filter(a -> a.getValue()>= 0.9 *raspuns1.get(a.getKey()))
				.map( u -> u.getKey())
				.collect(Collectors.toList());
				return raspunsFinal;		
	}
	public static void main(String[] args) {
			ArrayList<MonitoredData> lista=populare();
			long nr1=two(lista);
			Map<String,Long> raspuns=three(lista);
			Stream<Entry<String, Long>> raspuns2=four(lista);
			List<String >raspuns3=five2(lista);
			Map<String,Long> raspuns4=six2(lista);
			ArrayList<String> raspuns5=seven(lista);
			for(MonitoredData d:lista) System.out.println(d);
			System.out.println("Raspunsul la punctul 2 este :"+nr1 +" zile");
			System.out.println("Raspunsul la punctul 3 este :");
			for(Entry<String, Long> s:raspuns.entrySet()) System.out.println("Actiunea "+s.getKey().trim()+" apare de:"+s.getValue());	
			System.out.println("Raspunsul la punctul 4 este :");
			raspuns2.forEach(System.out::println);
			System.out.println("Raspunsul la punctul 5 este :");
			for(String s:raspuns3)
			{System.out.println(s);
			}
			System.out.println("Raspunsul la punctul 6 este :");
			for(Entry<String, Long> s:raspuns4.entrySet())
			{
				long ho=s.getValue() / 3600;
				String hours =ho +"";
				long mi=(s.getValue() % 3600) / 60;
				String minutes = mi+"";
				long se=s.getValue() % 60;
				String seconds = se+"";
				System.out.println("Activitatea "+s.getKey()+" dureaza:"+hours+":"+minutes+":"+seconds);
			}
			System.out.println("Raspunsul la punctul 7 este :");
			for(String s:raspuns5)
			{	System.out.println(s);
			}
	}
}
