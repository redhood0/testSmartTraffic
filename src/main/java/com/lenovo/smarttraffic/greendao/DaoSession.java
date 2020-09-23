package com.lenovo.smarttraffic.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.lenovo.smarttraffic.bean.ChongZhiRecord;
import com.lenovo.smarttraffic.bean.Q5GreenBean;

import com.lenovo.smarttraffic.greendao.ChongZhiRecordDao;
import com.lenovo.smarttraffic.greendao.Q5GreenBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig chongZhiRecordDaoConfig;
    private final DaoConfig q5GreenBeanDaoConfig;

    private final ChongZhiRecordDao chongZhiRecordDao;
    private final Q5GreenBeanDao q5GreenBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        chongZhiRecordDaoConfig = daoConfigMap.get(ChongZhiRecordDao.class).clone();
        chongZhiRecordDaoConfig.initIdentityScope(type);

        q5GreenBeanDaoConfig = daoConfigMap.get(Q5GreenBeanDao.class).clone();
        q5GreenBeanDaoConfig.initIdentityScope(type);

        chongZhiRecordDao = new ChongZhiRecordDao(chongZhiRecordDaoConfig, this);
        q5GreenBeanDao = new Q5GreenBeanDao(q5GreenBeanDaoConfig, this);

        registerDao(ChongZhiRecord.class, chongZhiRecordDao);
        registerDao(Q5GreenBean.class, q5GreenBeanDao);
    }
    
    public void clear() {
        chongZhiRecordDaoConfig.clearIdentityScope();
        q5GreenBeanDaoConfig.clearIdentityScope();
    }

    public ChongZhiRecordDao getChongZhiRecordDao() {
        return chongZhiRecordDao;
    }

    public Q5GreenBeanDao getQ5GreenBeanDao() {
        return q5GreenBeanDao;
    }

}