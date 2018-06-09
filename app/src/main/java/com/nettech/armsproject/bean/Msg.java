package com.nettech.armsproject.bean;

/**
 * Created by ASUS on 2018/5/14.
 */

public class Msg {

    /**
     * id : 215
     * time : 1524622573000
     * type : 5
     * state : 1
     * question : {"id":152455291127559,"title":"这不是一家烤肉店吗？桌子上怎么没有烤炉.大家有推理吗？"}
     * answer : {"id":77,"content":"这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.￼http://image.ibbtech.cn/image/20becc76-c5b7-4cf5-85be-4e6a95679cd3.jpg\n这不是一家烤肉店吗？桌子上怎么没有烤炉."}
     * reply : {"id":33,"content":"哈哈哈哈哈 挂羊头卖狗肉啊"}
     * receiver : {"id":34183373848578,"nickname":"测试人员111","portrait":"http://image.ibbtech.cn/image/8b648aa9-557c-4c23-811f-016c95cfe8de.jpg","signature":"签名不知道怎么填","location":"北京市 北京市 房山区","sex":1,"relation":0}
     * sender : {"id":34179807641601,"nickname":"disypen","portrait":"http://oss.ibbtech.cn/headimage.png","signature":"even you ","location":null,"sex":0,"relation":0}
     */

    private int id;
    private long time;
    private int type;
    private int state;
    private QuestionBean question;
    private AnswerBean answer;
    private ReplyBean reply;
    private ReceiverBean receiver;
    private SenderBean sender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public QuestionBean getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBean question) {
        this.question = question;
    }

    public AnswerBean getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerBean answer) {
        this.answer = answer;
    }

    public ReplyBean getReply() {
        return reply;
    }

    public void setReply(ReplyBean reply) {
        this.reply = reply;
    }

    public ReceiverBean getReceiver() {
        return receiver;
    }

    public void setReceiver(ReceiverBean receiver) {
        this.receiver = receiver;
    }

    public SenderBean getSender() {
        return sender;
    }

    public void setSender(SenderBean sender) {
        this.sender = sender;
    }

    public static class QuestionBean {
        /**
         * id : 152455291127559
         * title : 这不是一家烤肉店吗？桌子上怎么没有烤炉.大家有推理吗？
         */

        private long id;
        private String title;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "QuestionBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public static class AnswerBean {
        public AnswerBean() {
        }

        /**
         * id : 77
         * content : 这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.￼http://image.ibbtech.cn/image/20becc76-c5b7-4cf5-85be-4e6a95679cd3.jpg
         这不是一家烤肉店吗？桌子上怎么没有烤炉.
         */

        private int id;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public AnswerBean(int id, String content) {
            this.id = id;
            this.content = content;
        }
    }

    public static class ReplyBean {
        /**
         * id : 33
         * content : 哈哈哈哈哈 挂羊头卖狗肉啊
         */

        private int id;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "ReplyBean{" +
                    "id=" + id +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

    public static class ReceiverBean {
        /**
         * id : 34183373848578
         * nickname : 测试人员111
         * portrait : http://image.ibbtech.cn/image/8b648aa9-557c-4c23-811f-016c95cfe8de.jpg
         * signature : 签名不知道怎么填
         * location : 北京市 北京市 房山区
         * sex : 1
         * relation : 0
         */

        private long id;
        private String nickname;
        private String portrait;
        private String signature;
        private String location;
        private int sex;
        private int relation;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getRelation() {
            return relation;
        }

        public void setRelation(int relation) {
            this.relation = relation;
        }

        @Override
        public String toString() {
            return "ReceiverBean{" +
                    "id=" + id +
                    ", nickname='" + nickname + '\'' +
                    ", portrait='" + portrait + '\'' +
                    ", signature='" + signature + '\'' +
                    ", location='" + location + '\'' +
                    ", sex=" + sex +
                    ", relation=" + relation +
                    '}';
        }
    }

    public static class SenderBean {
        /**
         * id : 34179807641601
         * nickname : disypen
         * portrait : http://oss.ibbtech.cn/headimage.png
         * signature : even you
         * location : null
         * sex : 0
         * relation : 0
         */

        private long id;
        private String nickname;
        private String portrait;
        private String signature;
        private Object location;
        private int sex;
        private int relation;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getRelation() {
            return relation;
        }

        public void setRelation(int relation) {
            this.relation = relation;
        }

        @Override
        public String toString() {
            return "SenderBean{" +
                    "id=" + id +
                    ", nickname='" + nickname + '\'' +
                    ", portrait='" + portrait + '\'' +
                    ", signature='" + signature + '\'' +
                    ", location=" + location +
                    ", sex=" + sex +
                    ", relation=" + relation +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", time=" + time +
                ", type=" + type +
                ", state=" + state +
                ", question=" + question +
                ", answer=" + answer +
                ", reply=" + reply +
                ", receiver=" + receiver +
                ", sender=" + sender +
                '}';
    }
}
