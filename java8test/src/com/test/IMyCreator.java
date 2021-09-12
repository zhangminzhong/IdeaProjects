package com.test;

import java.util.List;

/**
 * Created by AdministratorZhang on 2019/11/4 20:21
 */
@FunctionalInterface
public interface IMyCreator<T extends List<?>> {
    T create();
}
