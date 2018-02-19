package configuration;

/**
 *
 * @author wangchunzi
 */
public abstract class KeyModel {

    /**
     * $1是状态码，$2是提示信息码
     */
    public static final String RETURN_JSON_MODEL = "{\"statusCode\":\"$1\",\"msg\":\"$2\"}";

    private static final String RETURN_JSON_MODEL_1 = "{\"statusCode\":\"";
    private static final String RETURN_JSON_MODEL_2 = "\",\"msg\":\"";
    private static final String RETURN_JSON_MODEL_3 = "\"}";

    final static public String getJSONModel(final String code, final String msg) {
        return RETURN_JSON_MODEL_1 + code + RETURN_JSON_MODEL_2 + msg + RETURN_JSON_MODEL_3;
    }

    /**
     *
     * @author wangchunzi
     */
    public enum ReturnKey {

        SUCESS(getJSONModel("1", "操作成功!")), ERROR(getJSONModel("0", "操作失败!")) //登陆超时
        , LOGIN_TIMEOUT(getJSONModel("100", "登陆超时，请重新登陆!"))
        
        , ADD_SUCESS(getJSONModel("1", "添加成功!")), ADD_ERROR(getJSONModel("0", "添加失败!")), ADD_UNIQUE(getJSONModel("-1", "添加失败，添加的新数据与其他的数据产生重复冲突，请注意要求填写唯一的项!"))
        
        , DELL_SUCESS(getJSONModel("1", "删除成功!")), DELL_ERROR(getJSONModel("0", "删除失败或此数据已经被删除!")) , DELL_UNIQUE(getJSONModel("-1", "删除失败，删除的数据中，数据被[锁定]或在其他模块[已经使用]!"))
        
        , UPDATE_SUCESS(getJSONModel("1", "修改成功!")), UPDATE_ERROR(getJSONModel("0", "修改失败!")), UPDATE_UNIQUE(getJSONModel("-1", "修改失败:修改的新数据与其他数据发生重复冲突!"));
        public final String statusCode;

        private ReturnKey(String i) {
            this.statusCode = i;
        }
        
    }

    public enum ParamKey {
        
        UPDATE_SELECT_PARAM_NAME("selectUpdateID")
        , DELET_VAST_PARAM_NAME("ids");
        
        
        public final String KEY;
        
        private ParamKey(String i) {
            this.KEY = i;
        }
    }
}
