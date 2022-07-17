package com.kch.ll.exam;


public class WiseSaying {
    public int id;
    public String content;
    public String author;
    // 작가가 없을 시 작자미상
    public WiseSaying(int id, String content){
        new WiseSaying(id, content, "작자미상");
    }

    public WiseSaying(int id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }
    // json으로 변환
    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "author": "%s"
                }
                """.stripIndent().formatted(id, content, author);
    }
}
