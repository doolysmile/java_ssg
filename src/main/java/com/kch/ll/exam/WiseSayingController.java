package com.kch.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;

    WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc){
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void test() {
        System.out.println("테스트");
    }
    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        wiseSayingService.write(content, author);
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    public void remove(RequestParams requestParams) {
        int id = Integer.parseInt(requestParams.getParamByKey("id"));

        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingService.remove(id);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void modify(RequestParams requestParams) {
        int id = Integer.parseInt(requestParams.getParamByKey("id"));

        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(id, content, author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }

    public void build() {
        wiseSayingService.saveFile();
    }


}
