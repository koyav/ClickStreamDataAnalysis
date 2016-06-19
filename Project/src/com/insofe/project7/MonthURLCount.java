package com.insofe.project7;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MonthURLCount {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		Configuration conf=new Configuration();
			Job job=Job.getInstance(conf, "MonthURLCount");
			job.setJarByClass(MonthURLCount.class);
			
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			job.setMapperClass(MonthURLMapper.class);
			job.setReducerClass(MonthURLReducer.class);
			
			job.setMapOutputKeyClass(IntWritable.class);
			job.setMapOutputValueClass(URLCount.class);
			
			job.setOutputKeyClass(IntWritable.class);
			job.setOutputValueClass(Text.class);
			
			job.waitForCompletion(true);

	}

}
