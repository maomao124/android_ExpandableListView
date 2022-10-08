package mao.android_expandablelistview.entity;

/**
 * Project name(项目名称)：android_ExpandableListView
 * Package(包名): mao.android_expandablelistview.entity
 * Class(类名): Group
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/8
 * Time(创建时间)： 14:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class Group
{
    /**
     * 名字
     */
    private String name;

    /**
     * Instantiates a new Group.
     */
    public Group()
    {
    }

    /**
     * Instantiates a new Group.
     *
     * @param name the name
     */
    public Group(String name)
    {
        this.name = name;
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
    public Group setName(String name)
    {
        this.name = name;
        return this;
    }
}
