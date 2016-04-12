package com.abe.max;

import java.io.IOException;
import java.util.Arrays;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

public class MaxTemperatureReducerTest {
	@Test
	public void returnsMaximumIntegerInValues() throws IOException, InterruptedException {
		new ReduceDriver<Text, IntWritable, Text, IntWritable>()
		.withReducer(new MaxTemperatureReducer())
		.withInput(new Text("1989"), Arrays.asList(new IntWritable(10), new IntWritable(5), new IntWritable(23)))
		.withOutput(new Text("1989"), new IntWritable(5))
		.runTest();
	}

}
