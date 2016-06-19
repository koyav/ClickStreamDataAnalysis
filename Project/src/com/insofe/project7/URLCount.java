package com.insofe.project7;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class URLCount implements WritableComparable<URLCount>{
	
	
	private Text url;
	
	private IntWritable count;
	
	public URLCount(){
		this.url = new Text("");
		this.count = new IntWritable(1);
	}
	
	public URLCount(String url,int count){
		this.url = new Text(url);
		this.count = new IntWritable(count);
	}
	
	
	@Override
	public int compareTo(URLCount o) {
		
		return this.getCount().compareTo(o.getCount());
			
	}

	@Override
	public void readFields(DataInput in) throws IOException {
			
		url.readFields(in);
		count.readFields(in);
	}

	@Override
	public void write(DataOutput out) throws IOException {

		url.write(out);
		count.write(out);
	}
	
	@Override
	public int hashCode(){
		return url.hashCode() * 163 * 317 + count.hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof URLCount){
			URLCount obj = (URLCount)o;
			return url.equals(obj.getUrl()) && count.equals(obj.getCount());
		}
		
		return false;
	}

	@Override
	public String toString(){
		return url.toString() + '\t' + count.toString();
	}
	
	
	public Text getUrl() {
		return url;
	}


	public void setUrl(Text url) {
		this.url = url;
	}


	public IntWritable getCount() {
		return count;
	}


	public void setCount(IntWritable count) {
		this.count = count;
	}

}
