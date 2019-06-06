package cn.bcf.bootstrap.service;

import cn.bcf.bootstrap.entity.HistoryEntity;
import cn.bcf.bootstrap.entity.UserEntity;

public interface HistoryService extends BaseService<HistoryEntity> {

    public HistoryEntity findByUserId(int userId);
}
