package com.rockthevote.grommet.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.rockthevote.grommet.R;
import com.rockthevote.grommet.ui.misc.BetterViewAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EditableActionView extends FrameLayout {
    @BindView(R.id.eav_better_view_animator) BetterViewAnimator viewAnimator;

    private EditableActionViewListener listener;

    public EditableActionView(Context context) {
        this(context, null);
    }

    public EditableActionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditableActionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.editable_action_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            ButterKnife.bind(this);
            showEditButton();
        }
    }

    public void setListener(EditableActionViewListener listener) {
        this.listener = listener;
    }

    @OnClick(R.id.eav_edit_button)
    public void onClickEdit(View v) {
        if (null != listener) {
            listener.onEdit();
        }
    }

    @OnClick(R.id.eav_cancel_button)
    public void onClickCancel(View v) {
        if (null != listener) {
            listener.onCancel();
        }
    }

    @OnClick(R.id.eav_save_button)
    public void onClickSave(View v) {
        if (null != listener) {
            listener.onSave();
        }
    }

    public void showSaveCancel() {
        viewAnimator.setDisplayedChildId(R.id.eav_edit_mode_layout);
    }

    public void showSpinner() {
        viewAnimator.setDisplayedChildId(R.id.eav_progress_bar);
    }

    public void showEditButton() {
        viewAnimator.setDisplayedChildId(R.id.eav_edit_button);
    }

    public interface EditableActionViewListener {
        void onEdit();

        void onCancel();

        void onSave();
    }
}