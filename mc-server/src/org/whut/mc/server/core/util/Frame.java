package org.whut.mc.server.core.util;

/**
 * Created by yangyang on 16-2-24.
 */
public class Frame {
    // begin util status bbh cs end
    public static final byte[] HEART_BEAT = {0x68, 0x00, 0x00, 0x01, 0x01, 0x01, 0x01, 0x01, 0x03, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x75, 0x16};
    // begin util status bbh cs end
    public static final byte[] HEART_BEAT2 = {0x68, 0x00, 0x00, 0x01, 0x01, 0x01, 0x01, 0x01, 0x03, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x02, 0x76, 0x16};
    // begin util status bbh cs end
    public static final byte[] HEART_BEAT3 = {0x68, 0x00, 0x00, 0x01, 0x01, 0x01, 0x01, 0x01, 0x03, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x03, 0x77, 0x16};
    // begin util status sbh cs end
    public static final byte[] ACK = {0x68, 0x00, 0x02, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x04, 0x77, 0x16};

    public static final byte[] LANYAN_OPEN = {0x68, 0x01, 0x0e, 0x01, 0x01, 0x01, 0x01, 0x01, 0x03, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x0f, 0x13, 0x16};
}
