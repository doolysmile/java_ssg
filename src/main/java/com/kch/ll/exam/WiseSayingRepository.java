package com.kch.ll.exam;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WiseSayingRepository {
    private WiseSayingTable wiseSayingTable;

    public WiseSayingRepository() {
        wiseSayingTable = new WiseSayingTable();
    }
    public WiseSaying write(String content, String author) {
        return wiseSayingTable.save(content, author);
    }



    public List<WiseSaying> findAll() {
        return wiseSayingTable.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingTable.findById(id);
    }

    public boolean modify(int id, String content, String author) {
        return wiseSayingTable.save(id, content, author);
    }

    public boolean remove(int id) {
        return wiseSayingTable.removeById(id);
    }

    public void saveFile(){
        wiseSayingTable.dumpToJson();
    }


}
