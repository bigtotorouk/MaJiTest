package com.maji.majitest

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.j256.ormlite.dao.Dao
import com.maji.majitest.bean.DataBean
import com.maji.majitest.db.TakeoutOpenHelper

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.maji.majitest", appContext.packageName)
    }

    @Test
    fun db_query() {//数据库查询测试
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val takeoutOpenHelper = TakeoutOpenHelper(appContext)
        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(DataBean::class.java)
        if(dao.count()>0){
            //show last data
            var bean: DataBean = dao.queryBuilder().orderBy("id", false).queryForFirst()
            assertNotNull(bean)
        }else{
            assertTrue(true)
        }
    }


    @Test
    fun db_insert() {//数据库新增数据测试
        var bean:DataBean = DataBean(
            authorizations_url= "ssfs",
            code_search_url="authorizations_url",
            commit_search_url= "test",
            current_user_authorizations_html_url= "test",
            current_user_repositories_url= "test",
            current_user_url= "test",
            emails_url= "test",
            emojis_url= "test",
            events_url= "test",
            feeds_url= "test",
            followers_url= "test",
            following_url= "test",
            gists_url= "test",
            hub_url= "test",
            issue_search_url= "test",
            issues_url= "test",
            keys_url= "test",
            label_search_url= "test",
            notifications_url= "test",
            organization_repositories_url= "test",
            organization_teams_url= "test",
            organization_url= "test",
            public_gists_url= "test",
            rate_limit_url= "test",
            repository_search_url= "test",
            repository_url= "test",
            starred_gists_url= "test",
            starred_url= "test",
            user_organizations_url= "test",
            user_repositories_url= "test",
            user_search_url= "test",
            user_url= "test"
        )
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val takeoutOpenHelper = TakeoutOpenHelper(appContext)
        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(
            DataBean::class.java)
        var row_id:Int = dao.create(bean)
        assertTrue(row_id>0)
    }
}
