package taro.rikkeisoft.com.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import taro.rikkeisoft.com.assignment.R;
import taro.rikkeisoft.com.assignment.model.Note;
import taro.rikkeisoft.com.assignment.utils.Utils;

/**
 * Created by VjrutNAT on 10/14/2017.
 */

public class CustomAdapterGridView extends BaseAdapter {

    private Context mContext;
    private ArrayList<Note> mData;
    private LayoutInflater mLayoutInflater;

    public CustomAdapterGridView(Context mContext, ArrayList<Note> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoller holler;
        if (view == null) {
            holler = new ViewHoller();
            view = mLayoutInflater.inflate(R.layout.item_gridview, viewGroup, false);
            holler.contentNote = view.findViewById(R.id.tv_note);
            holler.titleNote = view.findViewById(R.id.tv_title);
            holler.timeNote = view.findViewById(R.id.tv_time);
            view.setTag(holler);
        } else {
            holler = (ViewHoller) view.getTag();
        }
        Note note = this.mData.get(i);
        holler.contentNote.setText(note.getContent());
        holler.titleNote.setText(note.getTitle());
        holler.timeNote.setText(Utils.shortDateFormat.format(note.getAlarm()));

        return view;
    }

    private static class ViewHoller {
        TextView contentNote;
        TextView timeNote;
        TextView titleNote;
        ;
    }
}
