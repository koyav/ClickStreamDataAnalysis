package com.insofe.project7;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MonthURLMapper extends Mapper<LongWritable, Text, IntWritable, URLCount> {

	
	  @Override
	  public void map(LongWritable key, Text value, Context context)
	      throws IOException, InterruptedException {

		  String line = value.toString();
		  String[] values = line.split("\t");
		  if(values.length == 3){
			  context.write(new IntWritable(Integer.parseInt(values[0])),new URLCount(values[1],Integer.parseInt(values[2])));
		  }
	}
}
