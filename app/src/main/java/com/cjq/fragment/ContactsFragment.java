package com.cjq.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjq.adapter.ContactsAdapter;
import com.cjq.domain.People;
import com.cjq.widget.IndexableListView;
import com.example.administrator.myapp.R;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {
    private Context context;
    private ArrayList<People> mItems;
    private IndexableListView mListView;
    private ContactsFragment c;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_constants, container,
                false);
        context = getActivity();

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mItems = new ArrayList<People>();
        People people = new People();
        people.setIcon("http://news.baidu.com/resource/media_icons/logo-pengpai.png?v=20150402");
        people.setName("胖胖");
        People people2 = new People();
        people2.setIcon("http://news.baidu.com/resource/media_icons/logo-pengpai.png?v=20150402");
        people2.setName("A");
        People people3 = new People();
        people3.setIcon("http://news.baidu.com/resource/media_icons/logo-pengpai.png?v=20150402");
        people3.setName("F");
        for (int i = 0; i < 6; i++) {
            mItems.add(people);
        }
        for (int i = 0; i < 6; i++) {
            mItems.add(people2);
        }
        for (int i = 0; i < 6; i++) {
            mItems.add(people3);
        }
        ContactsAdapter adapter = new ContactsAdapter(getActivity(),
                mItems);

        mListView = (IndexableListView) view.findViewById(R.id.listview);
        mListView.setAdapter(adapter);
        mListView.setFastScrollEnabled(true);
    }


    public static ContactsFragment newInstance(String s) {
        ContactsFragment newFragment = new ContactsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hello", s);
        newFragment.setArguments(bundle);
        return newFragment;

    }

}
