/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power;

/**
 *
 * @author jweb
 */
public class JSPStr {

    private final StringBuilder sb = new StringBuilder();

    public JSPStr put(final boolean isOK, final String str) {
        if (isOK) {
            sb.append(sb.length() > 0 ? "," + str : str);
        }
        return this;
    }

    public JSPStr put(final boolean isOK, String fh, final String str) {
        if (isOK) {
            sb.append(sb.length() > 0 ? fh + str : str);
        }
        return this;
    }

    /**
     * 前面不为空时，追加str。前面为空时，不追加str。
     *
     * @param str
     * @return
     */
    public JSPStr putByNotEmptyQZ(final String str) {
        if (sb.length() > 0) {
            sb.append(",").append(str);
        }
        return this;
    }

    public String getString() {
        return sb.toString();
    }
}
