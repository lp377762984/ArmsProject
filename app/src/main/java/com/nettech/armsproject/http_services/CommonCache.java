package com.nettech.armsproject.http_services;

import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.Result;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

public interface CommonCache {
    @LifeCache(duration = 5,timeUnit = TimeUnit.MINUTES)
    Observable<Reply<Result<LoginEntity>>> getUsers(Observable<Result<LoginEntity>> loginEntity, DynamicKey idLastUserQueried, EvictProvider evictProvider);
}
