package net.patrickvogt.pinkball.util;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public final class PropertiesProvider
{
    private static final String LANG_DE = "de_DE";
    private static final String LANG_ZH = "zh_CN";

    private static PropertiesProvider _instance = null;
    private Properties _properties = null;

    private PropertiesProvider()
    {
        try
        {
            String source_path = "";
            
            String locale = Locale.getDefault().toString();
            if(locale.equals(PropertiesProvider.LANG_DE))
            {
                source_path = "/langs/deutsch.lang";
            }
            else if(locale.equals(PropertiesProvider.LANG_ZH))
            {
                source_path = "/langs/chinese.lang";
            }
            final InputStream stream = this.getClass().getResourceAsStream(
                    source_path);
            this._properties = new Properties();
            this._properties.load(stream);
            stream.close();
        }
        catch(final Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public final static PropertiesProvider getInstance()
    {
        if(null == PropertiesProvider._instance)
        {
            PropertiesProvider._instance = new PropertiesProvider();
        }
        return PropertiesProvider._instance;
    }

    public final String get(final String prop_key, final String default_string)
    {
        if(null != this._properties)
        {
            return this._properties.getProperty(prop_key, default_string);
        }
        return "";
    }
}
