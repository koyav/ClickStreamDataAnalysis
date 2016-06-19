package com.insofe.project7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountryURLReducer extends	Reducer<Text, URLCount, Text, Text> {

	 @Override
	  public void reduce(Text key, Iterable<URLCount> values, Context context)
	      throws IOException, InterruptedException {
		 
		 List<URLCount> list = new ArrayList<URLCount>();
		 
		 for(URLCount urlcount : values){
			 
			 list.add(new URLCount(urlcount.getUrl().toString(),urlcount.getCount().get()));

		 }
		 
		 int i =0;
		 
		 Collections.sort(list);
		 
		 for(int j=list.size()-1;j>-1;j--){
			 context.write(key, new Text(list.get(j).toString()));
			 if(i==9){
				 break;
			 } else {
				 i++;
			 }
		 }

	  }
}
