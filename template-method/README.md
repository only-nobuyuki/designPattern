---
レイアウト：パターン
title：テンプレートメソッド
フォルダー：template-method
パーマリンク：/ patterns / template-method /
カテゴリ：行動
タグ：
 -ギャングオブフォー
---

## 意図

操作でアルゴリズムのスケルトンを定義し、いくつかを延期する
サブクラスへのステップ。テンプレートメソッドを使用すると、サブクラスで特定のステップを再定義できます。
アルゴリズムの構造を変更しないアルゴリズム。

サブクラスがテンプレートメソッドをオーバーライドしないようにするには、テンプレートメソッドを「final」と宣言する必要があります。

## クラス図

！[alt text]（./ etc / template-method_1.png "テンプレートメソッド"）

## 適用性

テンプレートメソッドパターンを使用する必要があります

*アルゴリズムの不変部分を一度実装し、サブクラスに任せて、変化する可能性のある動作を実装する
*コードの重複を避けるために、サブクラス間の共通の動作をファクタリングし、共通クラスにローカライズする必要がある場合。これは、OpdykeとJohnsonが説明した「一般化するリファクタリング」の良い例です。最初に既存のコードの違いを特定し、次に違いを新しい操作に分けます。最後に、これらの新しい操作の1つを呼び出すテンプレートメソッドで、異なるコードを置き換えます
*サブクラス拡張機能を制御するため。特定のポイントで「フック」操作を呼び出すテンプレートメソッドを定義して、それらのポイントでのみ拡張を許可できます。

## チュートリアル

* [テンプレートメソッドパターンチュートリアル]（https://www.journaldev.com/1763/template-method-design-pattern-in-java）

## 実世界の例

* [javax.servlet.GenericServlet.init]（https://jakarta.ee/specifications/servlet/4.0/apidocs/javax/servlet/GenericServlet.html#init--）：
  メソッド `GenericServlet.init（ServletConfig
  config）`は、サブクラスでオーバーライドされることを目的としたパラメーターなしのメソッド
  `GenericServlet.init（）`を呼び出します。 メソッド
  `GenericServlet.init（ServletConfig
  config）`は、この例のテンプレートメソッドです。

## クレジット

* [デザインパターン：再利用可能なオブジェクト指向ソフトウェアの要素]（http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612）

