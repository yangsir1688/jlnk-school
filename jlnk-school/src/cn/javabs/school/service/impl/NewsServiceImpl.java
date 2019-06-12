package cn.javabs.school.service.impl;

import cn.javabs.school.dao.NewsDao;
import cn.javabs.school.dao.impl.NewsDaoImpl;
import cn.javabs.school.entity.News;
import cn.javabs.school.service.NewsService;

public class NewsServiceImpl implements NewsService {

    NewsDao newsDao = new NewsDaoImpl();

    @Override
    public int addNews(News news) {
        return newsDao.addNews(news);
    }
}
