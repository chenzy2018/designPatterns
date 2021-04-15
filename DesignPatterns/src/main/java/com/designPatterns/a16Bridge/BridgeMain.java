package com.designPatterns.a16Bridge;

/**
 * 桥接模式
 *
 * 场景：男孩选择喜欢的女孩并送礼物
 *  礼物：有m种描述(比如狂野型的、温柔型的、冷酷型的...)，有n个实体(比如书、戒指、花...)，结合就会有m*n个实体 --> 类爆炸
 *      --> 桥接模式解决，灵魂依赖实体，抽象依赖实现
 */
public class BridgeMain {
    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.choose(new Girl("Amy")).give(new WarmGift(new Book("设计模式")));
        boy.choose(new Girl("Alix")).give(new WildGift(new Flower("野玫瑰")));
    }
}
class Boy{
    Girl girl;

    public Boy choose(Girl girl){
        this.girl = girl;
        return this;
    }

    public void give(Gift gift){
        System.out.println(this.girl.name + "收到了" + gift.giftImpl.name);
    }
}
class Girl{
    String name;

    public Girl(String name) {
        this.name = name;
    }
}
//礼物类，里面保存礼物实体
abstract class Gift{
    GiftImpl giftImpl;//传入一个实体
}
//温暖型礼物
class WarmGift extends Gift{
    public WarmGift(GiftImpl giftImpl) {
        this.giftImpl = giftImpl;
    }
}
//狂野型礼物
class WildGift extends Gift{
    public WildGift(GiftImpl giftImpl) {
        this.giftImpl = giftImpl;
    }
}
//继续扩展...

//礼物实体
abstract class GiftImpl{
    String name;

    public GiftImpl(String name) {
        this.name = name;
    }
}
class Book extends GiftImpl{
    public Book(String name) {
        super(name);
    }
}
class Flower extends GiftImpl{
    public Flower(String name) {
        super(name);
    }
}
//继续扩展...