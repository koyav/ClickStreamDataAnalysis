package com.insofe.project7;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CountryURLCount {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		Configuration conf=new Configuration();
			Job job=Job.getInstance(conf, "CountryURLCount");
			job.setJarByClass(CountryURLCount.class);
			
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			job.setMapperClass(CountryURLMapper.class);
			job.setReducerClass(CountryURLReducer.class);
			
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(URLCount.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			job.waitForCompletion(true);

	}

}
