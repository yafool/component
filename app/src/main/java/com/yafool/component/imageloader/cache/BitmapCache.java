/*
 *   Copyright (C) 2019 yafool Individual developer
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.yafool.component.imageloader.cache;

import android.graphics.Bitmap;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.HONEYCOMB_MR1;

/**
 * @Package: com.yafool.component.imageloader.cache
 * @ClassName: com.yafool.component.imageloader.cache.BitmapCache.java
 * @Description: TODO
 * @CreateDate: 2019/4/26 1:55 PM
 * @Author: yafool
 * @Email: yafool@icloud.com
 * @UpdateUser: yafool
 * @UpdateDate: 2019/4/26 1:55 PM
 */
public class BitmapCache extends SoftLruCache<String, Bitmap> {

    public BitmapCache() {
        super();
    }

    public BitmapCache(int capacity) {
        super(capacity);
    }

    @Override
    public int sizeof(Bitmap bitmap) {
        int bytes = SDK_INT >= HONEYCOMB_MR1 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
        if (bytes < 0) {
            throw new IllegalStateException("Bitmap size is negative. Size=" + bitmap);
        }
        return bytes;
    }

    @Override
    public String className() {
        return BitmapCache.class.getName();
    }
}
