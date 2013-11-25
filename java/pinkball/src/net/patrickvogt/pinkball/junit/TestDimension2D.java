package net.patrickvogt.pinkball.junit;

import net.patrickvogt.pinkball.vector.Dimension2D;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDimension2D
{
    private Dimension2D tmp1 = null;
    
    @Before
    public void setUp()
    {
        this.tmp1 = new Dimension2D(1.0f, 10.0f);
    }
    
    @After
    public void TearDown()
    {
        this.tmp1 = null;
    }

    @Test
    public void test0()
    {        
        Assert.assertEquals(1.0f, this.tmp1.getWidth(), TestConstants.delta);
        Assert.assertEquals(10.0f, this.tmp1.getHeight(), TestConstants.delta);
    }
    
    @Test
    public void test1()
    {
        
        Assert.assertEquals(1.0f, tmp1.getWidth(), TestConstants.delta);
        Assert.assertEquals(10.0f, tmp1.getHeight(), TestConstants.delta);
    }
    
    @Test
    public void test2()
    {
        Dimension2D tmp2 = new Dimension2D(tmp1);
        
        Assert.assertTrue(tmp1.equals(tmp2));
    }
    
    @Test
    public void test3()
    {
        Dimension2D tmp2 = new Dimension2D(tmp1);
        
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
        Dimension2D tmp2 = new Dimension2D(1.1f, 10.0f);
        
        Assert.assertFalse(tmp2.equals(tmp1));
    }
    
    @Test
    public void test6()
    {
        Dimension2D tmp2 = new Dimension2D(1.1f, 10.0f);
        
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