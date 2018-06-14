package com.project.spring.service;

import com.project.spring.dao.LangDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LangServiceImpl implements LangService {

    private LangDao langDao;

    public void setLangDao(LangDao langDao){
        this.langDao = langDao;
    }


    @Override
    @Transactional
    public String getLangText(String language) {
        return langDao.getLangText(language);
    }
}
