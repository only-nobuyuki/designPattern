/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.iluwatar.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StealingMethod defines skeleton for the algorithm.
 */
//抽象クラス
public abstract class StealingMethod {


    //StealingMethodクラスのログ取る
    private static final Logger LOGGER = LoggerFactory.getLogger(StealingMethod.class);

    //抽象メソッド
    protected abstract String pickTarget();

    protected abstract void confuseTarget(String target);

    protected abstract void stealTheItem(String target);

    protected abstract void giveBack(String target);

    //stealメソッドを宣言。
    public void steal() {
        //pickTargetメソッドの戻り値を変数targetに設定。
        var target = pickTarget();
        LOGGER.info("ターゲットは{}として選択されました.", target);
        confuseTarget(target);
        stealTheItem(target);
        giveBack(target);
    }
}
