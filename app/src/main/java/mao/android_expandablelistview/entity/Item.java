package mao.android_expandablelistview.entity;

/**
 * Project name(项目名称)：android_ExpandableListView
 * Package(包名): mao.android_expandablelistview.entity
 * Class(类名): Item
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/8
 * Time(创建时间)： 14:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class Item
{
    /**
     * 图标
     */
    private int icon;

    /**
     * 名字
     */
    private String name;

    /**
     * Instantiates a new Item.
     */
    public Item()
    {
    }

    /**
     * Instantiates a new Item.
     *
     * @param icon the icon
     * @param name the name
     */
    public Item(int icon, String name)
    {
        this.icon = icon;
        this.name = name;
    }


    /**
     * Gets icon.
     *
     * @return the icon
     */
    public int getIcon()
    {
        return icon;
    }

    /**
     * Sets icon.
     *
     * @param icon the icon
     * @return the icon
     */
    public Item setIcon(int icon)
    {
        this.icon = icon;
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public Item setName(String name)
    {
        this.name = name;
        return this;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (getIcon() != item.getIcon()) return false;
        return getName() != null ? getName().equals(item.getName()) : item.getName() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getIcon();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }


    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("icon：").append(icon).append('\n');
        stringbuilder.append("name：").append(name).append('\n');
        return stringbuilder.toString();
    }
}
