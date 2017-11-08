package test;

import com.sun.istack.internal.Nullable;
import lsg.armor.ArmorItem;
import lsg.weapons.Weapon;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.HashSet;

public class CharacterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void existCollectibleInterface() {
        try {
            Class<?> c = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC | Modifier.ABSTRACT);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        }
    }

    @Test
    public void testCollectibleArmorItem() {
        try {
            Class<?> c = Class.forName("lsg.armor.ArmorItem");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 4);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.armor.ArmorItem");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleWeapon() {
        try {
            Class<?> c = Class.forName("lsg.weapons.Weapon");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.weapons.Claw");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 2);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.weapon.Weapons");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleConsumable() {
        try {
            Class<?> c = Class.forName("lsg.consumables.Consumable");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.consumables.Consumable");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleBuffItem() {
        try {
            Class<?> c = Class.forName("lsg.buffs.BuffItem");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.buffs.rings.RingOfDeath");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.buffs.BuffItem");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleDragonSlayerLeggings() {
        try {
            Class<?> c = Class.forName("lsg.armor.DragonSlayerLeggings");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 3);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.armor.DragonSlayerLeggings");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void existBagClass() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");

            Assert.assertTrue(true);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        }
    }

    @Test
    public void testBagAttributes() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Field f1 = c.getDeclaredField("capacity");
            Field f2 = c.getDeclaredField("weight");
            Field f3 = c.getDeclaredField("items");

            Assert.assertEquals(f1.getModifiers(), Modifier.PRIVATE);
            Assert.assertEquals(f1.getType(), int.class);

            Assert.assertEquals(f2.getModifiers(), Modifier.PRIVATE);
            Assert.assertEquals(f2.getType(), int.class);

            Assert.assertEquals(f3.getModifiers(), Modifier.PRIVATE);
            Assert.assertEquals(f3.getType(), HashSet.class);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchFieldException e) {
            Assert.fail("should have an attribute named capacity or weight or items");
        }
    }

    @Test
    public void testBagConstructorAndGetters() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(10);
            Method m1 = c.getDeclaredMethod("getWeight");
            Method m2 = c.getDeclaredMethod("getCapacity");

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m1.getReturnType() == int.class);
            Assert.assertTrue("wrong return type (int) of getCapacity", m2.getReturnType() == int.class);

            Assert.assertEquals((int) (m1.invoke(o)), 0);
            Assert.assertEquals((int) (m2.invoke(o)), 10);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a constructor with one parameter called capacity");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagPush() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c3 = Class.forName("[Llsg.bags.Collectible;");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(1);
            Method m1 = c.getDeclaredMethod("push", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (void) of push", m1.getReturnType() == void.class);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m1.invoke(o, o2);

            Method m2 = c.getDeclaredMethod("getItems");

            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (Collectible[]) of getItems", m2.getReturnType() == c3);

            Object o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 1);

            Object o4 = constructor2.newInstance();
            m1.invoke(o, o4);
            o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push or getItems");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagPop() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c3 = Class.forName("[Llsg.bags.Collectible;");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(1);
            Method m = c.getDeclaredMethod("push", i);
            Method m1 = c.getDeclaredMethod("pop", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (void) of pop", m1.getReturnType() == i);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);

            Method m2 = c.getDeclaredMethod("getItems");

            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (Collectible[]) of getItems", m2.getReturnType() == c3);

            Object o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 1);

            Object o4 = m1.invoke(o, o2);

            Assert.assertEquals(o4.getClass(), c2);

            o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 0);

            Object o5 = m1.invoke(o, o2);

            Assert.assertEquals(o5, null);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push, pop or getItems");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagContains() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(1);
            Method m = c.getDeclaredMethod("push", i);
            Method m1 = c.getDeclaredMethod("contains", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (bool) of contains", m1.getReturnType() == boolean.class);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);

            Assert.assertEquals((boolean)(m1.invoke(o, o2)), true);

            Object o3 = constructor2.newInstance();

            Assert.assertEquals((boolean)(m1.invoke(o, o3)), false);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push or contains");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagToString() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(10);
            Method m = c.getDeclaredMethod("push", i);
            Method m1 = c.getDeclaredMethod("toString");

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (String) of toString", m1.getReturnType() == String.class);

            Assert.assertEquals((String)(m1.invoke(o)), "Bag [ 0 items | 0/10 kg ]\n" +
                    "∙ (empty)");

            Class<?> c2 = Class.forName("lsg.weapons.ShotGun");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);

            Class<?> c3 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor3 = c3.getDeclaredConstructor();
            Object o3 = constructor3.newInstance();

            m.invoke(o, o3);

            Class<?> c4 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m.invoke(o, o4);

            Assert.assertEquals((String)(m1.invoke(o)), "Bag [ 3 items | 9/10 kg ]\n" +
                    "∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]\n" +
                    "∙ Dragon Slayer Leggings(10.2)[3 kg]\n" +
                    "∙ Ringed Knight Armor(14.99)[4 kg]\n");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push or toString");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existSmallBagClass() {
        try {
            Class<?> c = Class.forName("lsg.bags.SmallBag");

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();
            Method m = c.getMethod("getCapacity");

            Assert.assertEquals((int) (m.invoke(o)), 10);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called SmallBag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existMediumBagClass() {
        try {
            Class<?> c = Class.forName("lsg.bags.MediumBag");

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();
            Method m = c.getMethod("getCapacity");

            Assert.assertEquals((int) (m.invoke(o)), 40);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called MediumBag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existBagMain() {
        try {
            Class<?> c = Class.forName("lsg.bags.SmallBag");
            Method m = c.getMethod("main", String[].class);
            Object[] args = new Object[1];

            args[0] = new String[]{};
            m.invoke(null, args);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals("SmallBag [ 4 items | 10/10 kg ]", list[0]);
            Assert.assertEquals("∙ Black Witch Veil(4.6)[4 kg]", list[1]);
            Assert.assertEquals("∙ Dragon Slayer Leggings(10.2)[3 kg]", list[2]);
            Assert.assertEquals("∙ Basic Sword (min:5 max:10 stam:20 dur:100)[2 kg]", list[3]);
            Assert.assertEquals("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]", list[4]);
            Assert.assertEquals("", list[5]);
            Assert.assertEquals("Pop sur Dragon Slayer Leggings(10.2)", list[6]);
            Assert.assertEquals("", list[7]);
            Assert.assertEquals("SmallBag [ 3 items | 7/10 kg ]", list[8]);
            Assert.assertEquals("∙ Black Witch Veil(4.6)[4 kg]", list[9]);
            Assert.assertEquals("∙ Basic Sword (min:5 max:10 stam:20 dur:100)[2 kg]", list[10]);
            Assert.assertEquals("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]", list[11]);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called MediumBag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }
}