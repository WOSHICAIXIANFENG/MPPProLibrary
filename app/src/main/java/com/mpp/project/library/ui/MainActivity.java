package com.mpp.project.library.ui;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mpp.project.datasource.bookEntity.Author;
import com.mpp.project.library.AppConfig;
import com.mpp.project.library.R;
import com.mpp.project.library.util.SPUtil;

import java.util.HashSet;
import java.util.Set;

import static com.mpp.project.library.R.id.nav_checkout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, INavigate {
    private Toolbar mToolbar;
    private Fragment mCurrentFragment;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    private TextView mUserNameTV;
    private TextView mPhoneTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        View headerLayout = mNavigationView.inflateHeaderView(R.layout.nav_header_main);
        mUserNameTV = (TextView) headerLayout.findViewById(R.id.tv_userName);
        mPhoneTV = (TextView) headerLayout.findViewById(R.id.tv_userPhone);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Get permission from SP
        initSelectedItemByPermit();
    }

    private void initSelectedItemByPermit() {
        Set<String> permits = SPUtil.getStringSetPreferences(this, AppConfig.KEY_SP_PERMISSION_LIST);
        if (permits != null) {
            if (permits.contains(AppConfig.PERMISSION_LIBRARIAN) || permits.contains(AppConfig.PERMISSION_BOTH)) {
                mNavigationView.setCheckedItem(R.id.nav_checkout);
                openCheckOutPage();
            } else if (permits.contains(AppConfig.PERMISSION_ADMIN)) {
                mNavigationView.setCheckedItem(R.id.nav_addBook);
                openAddBookPage();
            }
        }

        String userName = SPUtil.getStringContentPreferences(this, AppConfig.KEY_SP_USERNAME);
        mUserNameTV.setText(userName);
        String phone = SPUtil.getStringContentPreferences(this, AppConfig.KEY_SP_PHONE);
        if (!TextUtils.isEmpty(phone)) {
            mPhoneTV.setText(phone);
        }

        Menu menu = mNavigationView.getMenu();
        if (permits.contains(AppConfig.PERMISSION_LIBRARIAN)) {
            menu.removeItem(R.id.nav_editMember);
            menu.removeItem(R.id.nav_addBook);
            menu.removeItem(R.id.nav_addCopy);
            menu.removeItem(R.id.nav_addMember);
        } else if (permits.contains(AppConfig.PERMISSION_ADMIN)) {
            menu.removeItem(R.id.nav_checkout);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void toggleDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    // done/save/submit item
    private MenuItem mDoneAction;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        // done/save/submit item
        mDoneAction = menu.getItem(0);
        mDoneAction.setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_down) {
            // todo
            String title = mDoneAction.getTitle().toString();
            System.out.println("Samuel Test title = " + title);

            if ("DONE".equals(title)) {


            } else if ("CheckOut".equals(title)) {
                // check out logic
                if (mCurrentFragment instanceof CheckoutFragment) {
                    CheckoutFragment checkoutFragment = (CheckoutFragment) mCurrentFragment;
                    checkoutFragment.doCheckoutLogic();
                }
            } else if ("Save".equals(title)) {
                if (mCurrentFragment instanceof AddAMemberFragment) {
                    AddAMemberFragment addAMemberFragment = (AddAMemberFragment) mCurrentFragment;
                    addAMemberFragment.doAddMemberLogic();
                } else if (mCurrentFragment instanceof EditMemberFragment) {
                    EditMemberFragment editMemberFragment = (EditMemberFragment) mCurrentFragment;
                    editMemberFragment.doEditMemberLogic();
                } else if (mCurrentFragment instanceof AddBookFragment) {
                    AddBookFragment addBookFragment = (AddBookFragment) mCurrentFragment;
                    addBookFragment.doAddBookLogic();
                } else if (mCurrentFragment instanceof AddAuthorDialog) {
                    AddAuthorDialog addAuthorDialog = (AddAuthorDialog) mCurrentFragment;
                    addAuthorDialog.doAddAuthorLogic();
                }

            } else if ("Edit".equals(title)) {
                if (mCurrentFragment instanceof EditMemberFragment) {
                    EditMemberFragment editMemberFragment = (EditMemberFragment) mCurrentFragment;
                    editMemberFragment.enableAllEditFields();
                    showSaveBtnFromEdit();
                }
            } else if ("Print".equals(title)) {
                if (mCurrentFragment instanceof QueryPrintFragment) {
                    QueryPrintFragment queryPrintFragment = (QueryPrintFragment) mCurrentFragment;
                    queryPrintFragment.printAllCheckoutRecord();
                }
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == nav_checkout) {
            // Handle the check out action
            openCheckOutPage();
        } else if (id == R.id.nav_addMember) {
            openAddMemberPage();
        } else if (id == R.id.nav_editMember) {
            openEditMemberPage();
        } else if (id == R.id.nav_addBook) {
            openAddBookPage();
        } else if (id == R.id.nav_addCopy) {
            openAddCopyPage();
        } else if (id == R.id.nav_queryPrint) {
            openQueryPrintPage();
        } else if (id == R.id.nav_logout) {
            showSimpleLogoutDialog();
        } else if (id == R.id.nav_setting) {
            // todo later
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void openAddAuthorPage() {
        mCurrentFragment = new AddAuthorDialog();
        getFragmentManager().beginTransaction().addToBackStack("AddAuthorDialog").replace(R.id.frame_content, mCurrentFragment).commit();
        mToolbar.setTitle("Add one author");

        // show back icon
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        if (mDoneAction != null)
            mDoneAction.setVisible(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentFragment instanceof AddAuthorDialog) {
                    getFragmentManager().popBackStackImmediate();
                    mCurrentFragment = getFragmentManager().findFragmentById(R.id.frame_content);
                    mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
                    if (mDoneAction != null)
                        mDoneAction.setVisible(false);
                } else {
                    // todo
                    toggleDrawer();
                }
            }
        });
    }

    @Override
    public void closeAddAuthorPage() {

    }

    @Override
    public void showSaveBtnForAddBook() {

    }

    @Override
    public void hideSaveBtnForAddBook() {

    }

    @Override
    public void showCheckOutBtn() {
        // show Check out btn on the top right area
        mDoneAction.setTitle("CheckOut");
        mDoneAction.setVisible(true);
    }

    @Override
    public void hideCheckOutBtn() {
        mDoneAction.setVisible(false);
    }

    @Override
    public void showEditBtn() {
        if (mDoneAction != null) {
            mDoneAction.setTitle("Edit");
            mDoneAction.setVisible(true);
        }
    }

    @Override
    public void showSaveBtnFromEdit() {
        if (mDoneAction != null) {
            mDoneAction.setTitle("Save");
            mDoneAction.setVisible(true);
        }
    }

    @Override
    public void showEditBtnFromSave() {
        showEditBtn();
    }

    @Override
    public void hideEditSaveBtn() {
        mDoneAction.setVisible(false);
    }

    @Override
    public void addAuthorDone(Author author) {
        if (mCurrentFragment instanceof AddAuthorDialog) {
            getFragmentManager().popBackStackImmediate();

            mCurrentFragment = getFragmentManager().findFragmentById(R.id.frame_content);
            mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
            //mDoneAction.setVisible(false);

            if (mCurrentFragment instanceof AddBookFragment) {
                AddBookFragment addBookFragment = (AddBookFragment) mCurrentFragment;
                addBookFragment.doAddOneAuthorLogic(author);
            }
        }
    }

    public void openCheckOutPage() {
        // use check out fragment to replace
        mCurrentFragment = new CheckoutFragment();
        getFragmentManager().beginTransaction().addToBackStack("CheckoutFragment").replace(R.id.frame_content, mCurrentFragment).commit();
        if (mToolbar != null)
            mToolbar.setTitle("Check Out");

        if (mDoneAction != null)
            mDoneAction.setVisible(false);
    }

    public void openAddMemberPage() {
        mCurrentFragment = new AddAMemberFragment();
        getFragmentManager().beginTransaction().addToBackStack("AddAMemberFragment").replace(R.id.frame_content, mCurrentFragment).commit();
        mToolbar.setTitle("Add Member");

        if (mDoneAction != null) {
            mDoneAction.setTitle("Save");
            mDoneAction.setVisible(true);
        }
    }

    public void openEditMemberPage() {
        mCurrentFragment = new EditMemberFragment();
        getFragmentManager().beginTransaction().addToBackStack("EditMemberFragment").replace(R.id.frame_content, mCurrentFragment).commit();
        mToolbar.setTitle("Edit Member");

        if (mDoneAction != null)
            mDoneAction.setVisible(false);
    }

    public void openAddBookPage() {
        mCurrentFragment = new AddBookFragment();
        getFragmentManager().beginTransaction().addToBackStack("AddBookFragment").replace(R.id.frame_content, mCurrentFragment).commit();
        mToolbar.setTitle("Add New Book");

        if (mDoneAction != null) {
            mDoneAction.setTitle("Save");
            mDoneAction.setVisible(true);
        }
    }

    public void openAddCopyPage() {
        mCurrentFragment = new AddCopyFragment();
        getFragmentManager().beginTransaction().addToBackStack("AddCopyFragment").replace(R.id.frame_content, mCurrentFragment).commit();
        mToolbar.setTitle("Add Copy");

        if (mDoneAction != null)
            mDoneAction.setVisible(false);
    }

    public void openQueryPrintPage() {
        mCurrentFragment = new QueryPrintFragment();
        getFragmentManager().beginTransaction().addToBackStack("QueryPrintFragment").replace(R.id.frame_content, mCurrentFragment).commit();
        mToolbar.setTitle("Query Records");

        if (mDoneAction != null) {
            mDoneAction.setTitle("Print");
            mDoneAction.setVisible(true);
        }
    }

    private void showSimpleLogoutDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(R.string.str_dialog_msg);

        //监听下方button点击事件
        builder.setPositiveButton(R.string.str_dialog_ok_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SPUtil.setBooleanPreferences(MainActivity.this, AppConfig.KEY_SP_HAS_LOGIN, false);
                Set<String> permits = new HashSet<>();
                SPUtil.setStringSetPreferences(MainActivity.this, AppConfig.KEY_SP_PERMISSION_LIST, permits);
                finish();
            }
        });
        builder.setNegativeButton(R.string.str_dialog_cancel_btn, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //设置对话框是可取消的
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
