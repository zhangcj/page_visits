package com.beecho.easyuse.kafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * Created by Administrator on 2017/6/30.
 */
public class SimplePartitioner implements Partitioner {
    public SimplePartitioner(VerifiableProperties props) {
    }

    @Override
    public int partition(Object o, int i) {
        int partition = 0;
        String stringKey = (String) o;
        int offset = stringKey.lastIndexOf('.');
        if (offset > 0) {
            partition = Integer.parseInt(stringKey.substring(offset + 1));
        }
        return partition;
    }
}
