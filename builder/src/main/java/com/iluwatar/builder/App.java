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

package com.iluwatar.builder;

import com.iluwatar.builder.Hero.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Builderパターンの意図は、伸縮するコンストラクタの解決策を見つけることです。
 * アンチパターン。テレスコープコンストラクタのアンチパターンは、オブジェクトの
 * コンストラクタのパラメータの組み合わせは、指数関数的なリストになります。コンストラクタを使用する代わりに
 * ビルダーパターンでは、別のオブジェクトであるビルダーを使用します。
 * 初期化パラメータをステップバイステップで設定し、構築されたオブジェクトを一度に返します。
 *
 <p>ビルダーパターンにはもう一つの利点があります。それは、フラットなデータを含むオブジェクトに使用することができます。
 * (htmlコード、SQLクエリ、X.509証明書など)、つまり簡単に編集できないデータです。
 * このタイプのデータは、段階的に編集することができず、一度に編集する必要があります。一番良い方法は、以下の通りです。
 * このようなオブジェクトを構築するには、ビルダークラスを使用します。
 *
 <p>この例では、Joshua Bloch氏が以下で説明しているように、Builderパターンのバリエーションを使用しています。
 * Effective Java 2nd Edition.
 *
 <p>{@link Hero}オブジェクトを構築したいのですが、多くのオブジェクトがあるため構築が複雑です。
 * 必要なパラメータを指定します。ユーザーを支援するために、{@link Builder}クラスを紹介します。リンクHero.Builder}は
 * リンクヒーロー}オブジェクトを構築するための最低限のパラメータをコンストラクタで指定します。その後、追加の
 * {@link Hero}オブジェクトの設定は、流暢な{@link Builder}インターフェイスを使用して行います。
 * 設定の準備ができたら、最終的な {@link Hero} オブジェクトを受け取るために build メソッドが呼ばれます。
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {

        Hero.Builder mage = new Hero.Builder(Profession.MAGE, "Riobard");
        //mage.withHairColor(HairColor.BLACK);
        //mage.withWeapon(Weapon.DAGGER);
        Hero man = mage.build();
        //LOGGER.info(mage.toString());
        System.out.println(man.getName());

        var warrior = new Hero.Builder(Profession.WARRIOR, "Amberjill");
        warrior.withHairColor(HairColor.BLOND);
        warrior.withHairType(HairType.LONG_CURLY);
        warrior.withArmor(Armor.CHAIN_MAIL);
        warrior.withWeapon(Weapon.SWORD);
        warrior.build();
        LOGGER.info(warrior.toString());

        var thief = new Hero.Builder(Profession.THIEF, "Desmond");
        thief.withHairType(HairType.BALD);
        thief.withWeapon(Weapon.BOW);
        thief.build();
        LOGGER.info(thief.toString());

    }
}
