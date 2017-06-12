package com.mercy.markus.sherlock;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizActivity extends AppCompatActivity {
    @BindView(R.id.checkbox_ten_1)
    CheckBox mCheckBox1;
    @BindView(R.id.checkbox_ten_2)
    CheckBox mCheckBox2;
    @BindView(R.id.checkbox_ten_3)
    CheckBox mCheckBox3;
    @BindView(R.id.checkbox_ten_4)
    CheckBox mCheckBox4;
    @BindView(R.id.edit_text)
    EditText mEditText;
    @BindView(R.id.radio_group_1)
    RadioGroup mRadioGroup1;
    @BindView(R.id.radio_group_2)
    RadioGroup mRadioGroup2;
    @BindView(R.id.radio_group_3)
    RadioGroup mRadioGroup3;
    @BindView(R.id.radio_group_4)
    RadioGroup mRadioGroup4;
    @BindView(R.id.radio_group_5)
    RadioGroup mRadioGroup5;
    @BindView(R.id.radio_group_6)
    RadioGroup mRadioGroup6;
    @BindView(R.id.radio_group_7)
    RadioGroup mRadioGroup7;
    @BindView(R.id.radio_group_9)
    RadioGroup mRadioGroup9;
    private int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, totalScore;
    private boolean checked1, checked2, checked3, checked4, checked5, checked6, checked7, checked9, checked10;
    private String editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);
    }

    //assigns score to question one on being checked
    public void onCheckedQuestion1(View view) {
        checked1 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_one_1:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.question_one_2:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.question_one_3:
                if (checked1) {
                    score1 = 10;
                    break;
                }
            case R.id.question_one_4:
                if (checked1) {
                    score1 = 0;
                    break;
                }
        }
    }

    //assigns score to question two on being checked
    public void onCheckedQuestion2(View view) {
        checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_two_1:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.question_two_2:
                if (checked2) {
                    score2 = 10;
                    break;
                }
            case R.id.question_two_3:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.question_two_4:
                if (checked2) {
                    score2 = 0;
                    break;
                }
        }
    }

    //assigns score to question three on being checked
    public void onCheckedQuestion3(View view) {
        checked3 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_three_1:
                if (checked3) {
                    score3 = 0;
                    break;
                }
            case R.id.question_three_2:
                if (checked3) {
                    score3 = 0;
                    break;
                }
            case R.id.question_three_3:
                if (checked3) {
                    score3 = 10;
                    break;
                }
            case R.id.question_three_4:
                if (checked3) {
                    score3 = 0;
                    break;
                }
        }
    }

    //assigns score to question four on being checked
    public void onCheckedQuestion4(View view) {
        checked4 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_four_1:
                if (checked4) {
                    score4 = 0;
                    break;
                }
            case R.id.question_four_2:
                if (checked4) {
                    score4 = 10;
                    break;
                }
            case R.id.question_four_3:
                if (checked4) {
                    score4 = 0;
                    break;
                }
            case R.id.question_four_4:
                if (checked4) {
                    score4 = 0;
                    break;
                }
        }
    }

    //assigns score to question five on being checked
    public void onCheckedQuestion5(View view) {
        checked5 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_five_1:
                if (checked5) {
                    score5 = 0;
                    break;
                }
            case R.id.question_five_2:
                if (checked5) {
                    score5 = 0;
                    break;
                }
            case R.id.question_five_3:
                if (checked5) {
                    score5 = 10;
                    break;
                }
            case R.id.question_five_4:
                if (checked5) {
                    score5 = 0;
                    break;
                }
        }
    }

    //assigns score to question six on being checked
    public void onCheckedQuestion6(View view) {
        checked6 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_six_1:
                if (checked6) {
                    score6 = 10;
                    break;
                }
            case R.id.question_six_2:
                if (checked6) {
                    score6 = 0;
                    break;
                }
            case R.id.question_six_3:
                if (checked6) {
                    score6 = 0;
                    break;
                }
            case R.id.question_six_4:
                if (checked6) {
                    score6 = 0;
                    break;
                }
        }
    }


    //assigns score to question seven on being checked
    public void onCheckedQuestion7(View view) {
        checked7 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_seven_1:
                if (checked7) {
                    score7 = 0;
                    break;
                }
            case R.id.question_seven_2:
                if (checked7) {
                    score7 = 0;
                    break;
                }
            case R.id.question_seven_3:
                if (checked7) {
                    score7 = 0;
                    break;
                }
            case R.id.question_seven_4:
                if (checked7) {
                    score7 = 10;
                    break;
                }
        }
    }


    //places a condition on the checkboxes in question 10
    public void onCheckedQuestion10(View view) {
        checked10 = mCheckBox1.isChecked() || mCheckBox2.isChecked() || mCheckBox3.isChecked() || mCheckBox4.isChecked();
    }


    //assigns score to question nine on being checked
    public void onCheckedQuestion9(View view) {
        checked9 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_nine_1:
                if (checked9) {
                    score9 = 0;
                    break;
                }
            case R.id.question_nine_2:
                if (checked9) {
                    score9 = 0;
                    break;
                }
            case R.id.question_nine_3:
                if (checked9) {
                    score9 = 10;
                    break;
                }
            case R.id.question_nine_4:
                if (checked9) {
                    score9 = 0;
                    break;
                }
        }
    }

    public void clickSubmit(View view) {
        editText = mEditText.getText().toString();
        if (checked1 && checked2 && checked3 && checked4 && checked5 && checked6 && checked7 && !editText.equals("") && checked9 && checked10) {

            // count question 8
            if (editText.toLowerCase().equals("liberty"))
                score8 = 10;
            else
                score8 = 0;

            // count question 10
            score10 = 0;
            if (mCheckBox1.isChecked()) {
                score10 += 0;
            }
            if (mCheckBox2.isChecked()) {
                score10 += 0;
            }
            if (mCheckBox3.isChecked()) {
                score10 += 5;
            }
            if (mCheckBox4.isChecked()) {
                score10 += 5;
            }
            //sums up total score
            totalScore = score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8 + score9 + score10;
            String anwser = getString(R.string.your_score_is) + "  " + totalScore;
            Toast.makeText(getApplicationContext(), anwser, Toast.LENGTH_LONG).show();
        } else {
            Context context = getApplicationContext();
            String text = getString(R.string.ensure_you_answer_all_questions);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    //reset radio buttons, editText field and checkBoxes using the uncheckedRadioGroup() and uncheckBoxes() methods;
    public void clickReset(View view) {
        uncheckRadioGroup(mRadioGroup1);
        uncheckRadioGroup(mRadioGroup2);
        uncheckRadioGroup(mRadioGroup3);
        uncheckRadioGroup(mRadioGroup4);
        uncheckRadioGroup(mRadioGroup5);
        uncheckRadioGroup(mRadioGroup6);
        uncheckRadioGroup(mRadioGroup7);
        uncheckRadioGroup(mRadioGroup9);
        mEditText.setText("");
        uncheckCheckBoxes();
    }

    private void uncheckRadioGroup(RadioGroup radioGroup) {
        radioGroup.clearCheck();
    }

    private void uncheckCheckBoxes() {
        mCheckBox1.setChecked(false);
        mCheckBox2.setChecked(false);
        mCheckBox3.setChecked(false);
        mCheckBox4.setChecked(false);
        checked10 = false;
    }
}

