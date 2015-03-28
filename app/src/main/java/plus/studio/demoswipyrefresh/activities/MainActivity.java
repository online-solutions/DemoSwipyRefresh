package plus.studio.demoswipyrefresh.activities;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import plus.studio.demoswipyrefresh.R;

/*

SwipyRefresh guideline unofficial
======
1. Download library, use gradle -> see build.gradle
2. Wrap your view by Swipy -> see activity_main.xml
3. Delare SwipyRefreshLayout
4. Set event, you have 2 option
4a. implement SwipyRefreshLayout -> override onRefresh
4b. Anonymous function -> same as onclickListener
5. My demo use 4b, you can see official demonstration, they implement SwipyRefreshLayout
6. You can see see refresh icon not same as official image, it happen because I don't have
any function to load -> short time -> refresh too fast
7. Need help -> ping me
*/


public class MainActivity extends ActionBarActivity{

    private SwipyRefreshLayout swipyRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        swipyRefreshLayout = (SwipyRefreshLayout) findViewById(R.id.swipy_layout);

        // set event directly
        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
                Toast.makeText(getApplicationContext(), "call web service, update UI... here", Toast.LENGTH_SHORT).show();

                // default = true
                // true -> not refresh anymore
                swipyRefreshLayout.setRefreshing(false);
            }
        });

        // use for implement
//        swipyRefreshLayout.setOnRefreshListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // use for implement
//    @Override
//    public void onRefresh(SwipyRefreshLayoutDirection direction) {
//        Log.d("MainActivity", "Refresh triggered at "
//                + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //Hide the refresh after 2sec
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        swipyRefreshLayout.setRefreshing(false);
//                    }
//                });
//            }
//        }, 2000);
//        Toast.makeText(getApplicationContext(), "after default onRefresh", Toast.LENGTH_SHORT).show();
//    }
}
