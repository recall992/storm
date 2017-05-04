package com.bjsxt.basic.wc;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

import java.util.Map;

public class MyRandomSentenceSpout extends BaseRichSpout {
	private static final long serialVersionUID = 1L;

	SpoutOutputCollector _collector;

	String[] sentences = new String[] { "a b c d ", "b c d e f", "a d e f" };

	@Override
	public void open(Map conf, TopologyContext context,
			SpoutOutputCollector collector) {
		_collector = collector;
	}

	@Override
	public void nextTuple() {
		for (String sentence : sentences) {
			_collector.emit(new Values(sentence));
		}
		Utils.sleep(10 * 1000);
	}

	@Override
	public void ack(Object id) {
	}

	@Override
	public void fail(Object id) {
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("sentence"));
	}

}