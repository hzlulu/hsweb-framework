/*
 *
 *  * Copyright 2020 http://www.hswebframework.org
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.hswebframework.web.api.crud.entity;


import org.hswebframework.web.bean.FastBeanCopier;
import org.hswebframework.web.validator.ValidatorUtils;

import java.io.Serializable;

/**
 * 实体总接口,所有实体需实现此接口
 *
 * @author zhouhao
 * @since 3.0
 */
public interface Entity extends Serializable {

    default void tryValidate(Class<?>... groups) {
        ValidatorUtils.tryValidate(this, groups);
    }

    default <T> T copyTo(Class<T> target, String... ignoreProperties) {
        return FastBeanCopier.copy(this, target, ignoreProperties);
    }

    default <T> T copyTo(T target, String... ignoreProperties) {
        return FastBeanCopier.copy(this, target, ignoreProperties);
    }

    @SuppressWarnings("all")
    default <T> T copyFrom(Object target, String... ignoreProperties) {
        return (T) FastBeanCopier.copy(target, this, ignoreProperties);
    }
}
