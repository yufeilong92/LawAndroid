package com.lawyee.lawyeehelper2.vo;

import java.util.List;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 14:22
 * 作用 :
 */
public class General_data {

    /**
     * text : Groceries
     * items : [{"text":"量刑指导工具","leaf":"true"},{"text":"人身损害赔偿计算工具","items":[{"text":"一般损害赔偿","leaf":"true"},{"text":"因伤致残损害赔偿","leaf":"true"},{"text":"死亡损害赔偿","leaf":"true"},{"text":"交强险责任分担计算","leaf":"true"}]},{"text":"劳动争议相关计算工具","items":[{"text":"一般工资赔偿计算","leaf":"true"},{"text":"五险一金赔偿计算","leaf":"true"},{"text":"工伤赔偿计算","items":[{"text":"一般工伤赔偿计算","leaf":"true"},{"text":"因工伤致残赔偿计算","items":[{"text":"一至四级","leaf":"true"},{"text":"五至十级","leaf":"true"}]},{"text":"因工伤死亡赔偿计算","leaf":"true"}]},{"text":"非工伤赔偿计算","leaf":"true"}]},{"text":"迟延履行利息计算工具","leaf":"true"},{"text":"利息计算工具","items":[{"text":"按存款利率计算","leaf":"true"},{"text":"按贷款利率计算","leaf":"true"},{"text":"利息快速计算","leaf":"true"},{"text":"按揭贷款计算器","leaf":"true"}]},{"text":"刑期折抵计算工具","leaf":"true"},{"text":"公告开庭日期计算工具","leaf":"true"},{"text":"诉讼费计算工具","leaf":"true"},{"text":"拆迁安置补偿计算工具","leaf":"true"},{"text":"征地赔偿计算工具","leaf":"true"},{"text":"继承纠纷计算工具","leaf":"true"},{"text":"立案审理计算工具","items":[{"text":"民事案件","leaf":"true"},{"text":"刑事案件","leaf":"true"},{"text":"行政案件","leaf":"true"},{"text":"国家赔偿","leaf":"true"},{"text":"执行案件","leaf":"true"}]},{"text":"刑法量刑对照工具","leaf":"true"},{"text":"日期计算工具","items":[{"text":"期间计算","leaf":"true"},{"text":"日期计算","leaf":"true"}]}]
     */

    private String text;
    private List<ItemsBeanX> items;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ItemsBeanX> getItems() {
        return items;
    }

    public void setItems(List<ItemsBeanX> items) {
        this.items = items;
    }

    public static class ItemsBeanX {
        /**
         * text : 量刑指导工具
         * leaf : true
         * items : [{"text":"一般损害赔偿","leaf":"true"},{"text":"因伤致残损害赔偿","leaf":"true"},{"text":"死亡损害赔偿","leaf":"true"},{"text":"交强险责任分担计算","leaf":"true"}]
         */

        private String text;
        private String leaf;
        private List<ItemsBean> items;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLeaf() {
            return leaf;
        }

        public void setLeaf(String leaf) {
            this.leaf = leaf;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * text : 一般损害赔偿
             * leaf : true
             */

            private String text;
            private String leaf;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getLeaf() {
                return leaf;
            }

            public void setLeaf(String leaf) {
                this.leaf = leaf;
            }
        }
    }
}
