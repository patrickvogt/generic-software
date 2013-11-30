package net.patrickvogt.pinkball.test.junit;

import net.patrickvogt.pinkball.vector.Vector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestVector
{
    private Vector tmp1 = null;
    
    @Before
    public void setUp()
    {
        this.tmp1 = new Vector(1.0f, 10.0f);
    }
    
    @After
    public void TearDown()
    {
        this.tmp1 = null;
    }

    @Test
    public void test0()
    {        
        Assert.assertEquals(1.0f, this.tmp1.getX(), TestConstants.delta);
        Assert.assertEquals(10.0f, this.tmp1.getY(), TestConstants.delta);
    }
    
    @Test
    public void test1()
    {
        
        Assert.assertEquals(1.0f, tmp1.getX(), TestConstants.delta);
        Assert.assertEquals(10.0f, tmp1.getY(), TestConstants.delta);
    }
    
    @Test
    public void test2()
    {
        Vector tmp2 = new Vector(tmp1);
        
        Assert.assertTrue(tmp1.equals(tmp2));
    }
    
    @Test
    public void test3()
    {
        Vector tmp2 = new Vector(tmp1);
        
        Assert.assertTrue(tmp2.equals(tmp1));
    }
    
    @Test
    public void test4()
    {       
        Assert.assertTrue(tmp1.equals(tmp1));
    }
    
    
    @Test
    public void test5()
    {
        Vector tmp2 = new Vector(1.1f, 10.0f);
        
        Assert.assertFalse(tmp2.equals(tmp1));
    }
    
    @Test
    public void test6()
    {
        Vector tmp2 = new Vector(1.1f, 10.0f);
        
        Assert.assertFalse(tmp1.equals(tmp2));
    }
    
    @Test
    public void test7()
    {      
        Assert.assertFalse(tmp1.equals("(1.0f, 10.0f)"));
    }
    
    @Test
    public void test8()
    {
        Assert.assertEquals("d(1.0,10.0)", tmp1.toString());
    }

}