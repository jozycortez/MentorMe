package mentorme.csumb.edu.mentorme.topicScreen;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mentorme.csumb.edu.mentorme.R;

/**
 * Created by benitosanchez on 11/12/16.
 */

public class TopicLayout {

    private final String TAG = "TopicLayout";

    private AppCompatActivity mActivity;
    private TopicLayoutListener mListener;

    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;
    @BindView(R.id.nav_view) NavigationView mNavigationView;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar_layout) Toolbar mToolbar;

    TopicLayout(AppCompatActivity activity, TopicLayoutListener listener) {
        mActivity = activity;
        mListener = listener;

        mActivity.setContentView(R.layout.activity_topic);

        ButterKnife.bind(this, mActivity);

        mActivity.setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                mActivity, mDrawer, mToolbar, R.string.open, R.string.close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @OnClick(R.id.nav_view)
    public void onNavigationMenuClick(){

        mListener.onNavigationMenuClick();
    }

    public interface TopicLayoutListener {
        void onNavigationMenuClick();
    }
}
