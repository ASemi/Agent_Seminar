package com.asemi.ailab.agent_seminar;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wataru on 17/02/19.
 */

public class PlayerFlagment extends RecyclerView.Adapter<PlayerFlagment.ViewHolder> {

    private static PlayerFlagment.OnItemClickListener listener;

    public void setOnItemClickListener(PlayerFlagment.OnItemClickListener listener) {
        PlayerFlagment.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // ...

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txt;
        private ImageButton btn_elem;
        public ViewHolder(final View itemView) {
            super(itemView);

             txt = (TextView) itemView.findViewById(R.id.list_item_text);
             btn_elem = (ImageButton) itemView.findViewById(R.id.btn_elem);

            txt.setOnClickListener(this);
            btn_elem.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(v, getLayoutPosition());
            }
        }

    }
}

}

    static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private PlayerFlagment playerFlagment;
        final LinearLayout linearLayout;

        public Holder(View itemview) {
            super(itemview);
            linearLayout = (LinearLayout) itemview.findViewById(R.id.);
            itemview.findViewById(R.id.recyclerView_strategy).setOnClickListener(this);
        }

        public void onClick(View view) {
            playerFlagment.onButtonClicked(getAdapterPosition());
        }
    }
}