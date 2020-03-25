---
layout: pattern
title: Builder
folder: builder
permalink: /patterns/builder/
categories: Creational
tags:
 - Gang of Four
---

## Intent
複雑なオブジェクトの構築を分離して
表現を使用することで、同じ構築プロセスで異なる
を表現しています

## Explanation

Real world example

>  ロールプレイングゲームのキャラクタージェネレーターを想像してみてください。最も簡単なオプションは、コンピュータがあなたのために文字を作成できるようにすることです。しかし、あなたが職業、性別、髪の色などのような文字の詳細を選択したい場合は、文字の生成は、すべての選択の準備ができているときに完了するステップバイステップのプロセスになります。
In plain words

> コンストラクタの汚染を避けながら、オブジェクトの異なるフレーバーを作成できるようにします。オブジェクトに複数のフレーバーがある場合に便利です。あるいは、オブジェクトの作成に多くのステップが必要な場合に便利です。

Wikipedia says

> ビルダーパターンは、テレスコーピングコンストラクタアンチパターンの解決策を見出すことを意図したオブジェクト作成ソフトのデザインパターンです。

ということで、テレスコーピングコンストラクタのアンチパターンとは何か、ということについて少し補足しておきます。誰もが一度は以下のようなコンストラクタを見たことがあると思います。

```java
public Hero(Profession profession, String name, HairType hairType, HairColor hairColor, Armor armor, Weapon weapon) {
}
```

ご覧のように、コンストラクタのパラメータの数が多いとすぐに手に負えなくなり、パラメータの配置を理解するのが難しくなるかもしれません。また、将来的にオプションを追加したい場合には、このパラメータリストは増え続ける可能性があります。これをテレスコピーンぐ・コンストラクタ・アンチパターンと呼びます。

**Programmatic Example**

まともな選択肢は、ビルダーパターンを使うことです。まず最初に、作成したいヒーローを用意します。

```java
public final class Hero {
  private final Profession profession;
  private final String name;
  private final HairType hairType;
  private final HairColor hairColor;
  private final Armor armor;
  private final Weapon weapon;

  private Hero(Builder builder) {
    this.profession = builder.profession;
    this.name = builder.name;
    this.hairColor = builder.hairColor;
    this.hairType = builder.hairType;
    this.weapon = builder.weapon;
    this.armor = builder.armor;
  }
}
```

そして、ビルダーには

```java
  public static class Builder {
    private final Profession profession;
    private final String name;
    private HairType hairType;
    private HairColor hairColor;
    private Armor armor;
    private Weapon weapon;

    public Builder(Profession profession, String name) {
      if (profession == null || name == null) {
        throw new IllegalArgumentException("profession and name can not be null");
      }
      this.profession = profession;
      this.name = name;
    }

    public Builder withHairType(HairType hairType) {
      this.hairType = hairType;
      return this;
    }

    public Builder withHairColor(HairColor hairColor) {
      this.hairColor = hairColor;
      return this;
    }

    public Builder withArmor(Armor armor) {
      this.armor = armor;
      return this;
    }

    public Builder withWeapon(Weapon weapon) {
      this.weapon = weapon;
      return this;
    }

    public Hero build() {
      return new Hero(this);
    }
  }
```

として使えるようになって

```java
var mage = new Hero.Builder(Profession.MAGE, "Riobard").withHairColor(HairColor.BLACK).withWeapon(Weapon.DAGGER).build();
```

## Class diagram
![alt text](./etc/builder.urm.png "Builder class diagram")

## Applicability
Builder パターンを使用する場合

* 複雑なオブジェクトを作成するためのアルゴリズムは、オブジェクトを構成する部品やその組み立て方法から独立している必要があります。
* 構築プロセスでは、構築されたオブジェクトに対して異なる表現を許可しなければなりません。

## Real world examples

* [java.lang.StringBuilder](http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html)
* [java.nio.ByteBuffer](http://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html#put-byte-) FloatBuffer や IntBuffer などの類似のバッファと同様に.
* [java.lang.StringBuffer](http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html#append-boolean-)
* All implementations of [java.lang.Appendable](http://docs.oracle.com/javase/8/docs/api/java/lang/Appendable.html)
* [Apache Camel builders](https://github.com/apache/camel/tree/0e195428ee04531be27a0b659005e3aa8d159d23/camel-core/src/main/java/org/apache/camel/builder)
* [Apache Commons Option.Builder](https://commons.apache.org/proper/commons-cli/apidocs/org/apache/commons/cli/Option.Builder.html)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
* [Effective Java (2nd Edition)](http://www.amazon.com/Effective-Java-Edition-Joshua-Bloch/dp/0321356683)
