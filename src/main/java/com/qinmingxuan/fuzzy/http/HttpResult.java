package com.qinmingxuan.fuzzy.http;



public class HttpResult<T> {

        private Integer code;
        private String msg;
        private T data;

        public static HttpResult error() {
            return error(HttpStatus.BAD_REQUEST.getCode(), "未知异常，请联系管理员");
        }

        public static HttpResult error(String msg) {
            return error(HttpStatus.BAD_REQUEST.getCode(), msg);
        }

        public static HttpResult error(String msg, String errorMsg) {
            String resultMsg = msg.concat(": ").concat(errorMsg);
            return error(resultMsg);
        }

        public static HttpResult error(int code, String msg) {
            HttpResult result = new HttpResult();
            result.setCode(code);
            result.setMsg(msg);
            return result;
        }

        public static HttpResult error(HttpStatus status) {
            return error(status.getCode(), status.getMsg());
        }

        public static HttpResult error(HttpStatus status, String msg) {
            return error(status.getCode(), msg);
        }

        public static HttpResult ok(String msg) {
            HttpResult result = new HttpResult();
            result.setCode(HttpStatus.SUCCESS.getCode());
            result.setMsg(msg);
            return result;
        }

        public static HttpResult ok(Object object) {
            HttpResult result = new HttpResult();
            result.setCode(HttpStatus.SUCCESS.getCode());
            result.setMsg(HttpStatus.SUCCESS.getMsg());
            result.setData(object);
            return result;
        }

        public static HttpResult ok() {
            return ok(HttpStatus.SUCCESS.getMsg());
        }

        public HttpResult() {
        }

        public Integer getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        public T getData() {
            return this.data;
        }

        public void setCode(final Integer code) {
            this.code = code;
        }

        public void setMsg(final String msg) {
            this.msg = msg;
        }

        public void setData(final T data) {
            this.data = data;
        }

        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof HttpResult)) {
                return false;
            } else {
                HttpResult<?> other = (HttpResult)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label47: {
                        Object this$code = this.getCode();
                        Object other$code = other.getCode();
                        if (this$code == null) {
                            if (other$code == null) {
                                break label47;
                            }
                        } else if (this$code.equals(other$code)) {
                            break label47;
                        }

                        return false;
                    }

                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if (this$msg == null) {
                        if (other$msg != null) {
                            return false;
                        }
                    } else if (!this$msg.equals(other$msg)) {
                        return false;
                    }

                    Object this$data = this.getData();
                    Object other$data = other.getData();
                    if (this$data == null) {
                        if (other$data != null) {
                            return false;
                        }
                    } else if (!this$data.equals(other$data)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(final Object other) {
            return other instanceof HttpResult;
        }



        public String toString() {
            return "HttpResult(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
        }

}
