package com.raksoct.ibonapp.Helpers;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;

import com.raksoct.ibonapp.Objects.Category;
import com.raksoct.ibonapp.Objects.Choice;
import com.raksoct.ibonapp.Objects.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/**
 * Created by Reiner on 8/6/2015.
 */
public class QuestionManager
{
    List<Category> Categories;

    public QuestionManager()
    {
        Categories = populateQuestions();
    }

    public List<Category> getCategories()
    {
        return this.Categories;
    }

    public Category getCategoryByID(int ID)
    {
        for (Category category : Categories)
        {
            if (ID == category.getID())
            {
                return category;
            }
        }
        return  null;
    }

    public Choice getCorrectAnswer(Question question)
    {
        for (Choice choice : question.getChoices())
        {
            if (choice.getIsCorrect())
            {
                return choice;
            }
        }
        return  null;
    }

    public static int getRandomInteger(int min, int max)
    {
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static String RomanNumerals(int Int)
    {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet())
        {
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    private static String repeat(String s, int n)
    {
        if(s == null)
        {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            sb.append(s);
        }
        return sb.toString();
    }

    public static List <Question> shuffleAndPrepareQuestionList(int quizSize, List<Question> questions)
    {
        //shuffle the questions
        Collections.shuffle(questions);
        //shuffle the choices within it.
        for (Question question : questions)
        {
            Collections.shuffle(question.getChoices());
        }

        List<Question> finalizedQuestions = new ArrayList<>();

        for (int i = 0; i < quizSize; i++)
        {
            finalizedQuestions.add(questions.get(i));
        }

        return finalizedQuestions;
    }

    //METHODS BELOW FILL UP THE QUESTIONS DATABASE!


    private List<Category> populateQuestions()
    {
        //Build the objects here, then add to Categories

        List<Category> compiledQuestions = new ArrayList<>();
        compiledQuestions.add(prepareCat1());
        compiledQuestions.add(prepareCat2());
        compiledQuestions.add(prepareCat3());
        compiledQuestions.add(prepareCat4());
        compiledQuestions.add(prepareCat5());
        compiledQuestions.add(prepareCat6());
        compiledQuestions.add(prepareCat7());
        compiledQuestions.add(prepareCat8());
        compiledQuestions.add(prepareCat9());
        compiledQuestions.add(prepareCat10());

        return compiledQuestions;
    }

    private Category prepareCat1()
    {
        Category cat1 = new Category();
        cat1.setHasQuestions(true);
        cat1.setID(1);
        cat1.setTitle("BUHAY NI BALAGTAS, KASAYSAYAN NG FLORANTE AT LAURA, MGA KATANGIAN NG ISANG AWIT");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("Sino sa mga ito ang naging guro ni Francisco Balagtas?");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("Jose dela Cruz", true));
        c1.add(new Choice("Jose Rizal", false));
        c1.add(new Choice("Hermenegildo Cruz", false));
        c1.add(new Choice("Lope Santos", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("Saan isinulat ni Balagtas ang awit na Florante at Laura?");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("Sa bilangguan", true));
        c2.add(new Choice("Sa isang kubo", false));
        c2.add(new Choice("Sa kainan", false));
        c2.add(new Choice("Sa simbahan", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("Sa anong klase ng pamilya nagmula si Balagtas?");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("Sa isang mahirap na pamilya", true));
        c3.add(new Choice("Sa isang mayamang pamilya", false));
        c3.add(new Choice("Sa isang middle-class na pamilya", false));
        c3.add(new Choice("Hindi tiyak", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("Alin sa mga ito ang tema o paksa ng awit na Florante at Laura?");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("Labanan ng Kristiyano at Moro", false));
        c4.add(new Choice("Baluktot na Pamahalaan", false));
        c4.add(new Choice("Pag-ibig", false));
        c4.add(new Choice("Lahat ng nabanggit", true));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("Sino sa mga ito ang nagsabing isang “kadluan ng matayog na pagsamba” si Balagtas?");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("Jose Rizal", true));
        c5.add(new Choice("Huseng Sisiw", false));
        c5.add(new Choice("Hermenegildo Cruz", false));
        c5.add(new Choice("Epifanio delos Santos", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("Alin sa mga ito ang unang hakbang sa pagbasa ng isang awit?");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("Pagbilog sa mga salitang ‘di maunawaan", true));
        c6.add(new Choice("Paghanap sa kahulugan nito", false));
        c6.add(new Choice("Pagbubuod ng saknong", false));
        c6.add(new Choice("Paghanap sa sinasabi ng taludtod", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("Ano ang tawag sa paghahati ng bawat taludtod kung saan ang bawat bahagi ay may diwa?");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("Sesura", true));
        c7.add(new Choice("Sesra", false));
        c7.add(new Choice("Sensura", false));
        c7.add(new Choice("Serusa", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("Ayon kay Hermenegildo Cruz, saan ipinanganak si Balagtas?");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("Bulacan", true));
        c8.add(new Choice("Tarlac", false));
        c8.add(new Choice("Zambales", false));
        c8.add(new Choice("Batangas", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("Isa sa mga naging inspirasyon ni Balagtas ay si M.A.R. Sino si M.A.R.?");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("Maria Asuncion Rivera", true));
        c9.add(new Choice("Magdalena Ana Ramos", false));
        c9.add(new Choice("Maria Ana Rivera", false));
        c9.add(new Choice("Magdalena Asuncion Ramos", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("Sininta ni Balagtas si M.A.R., ngunit may umagaw sa kanya mula kay Balagtas. Sino itong umagaw kay M.A.R.?");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("Mariano Kapuli", true));
        c10.add(new Choice("Gob. Narciso Claveria", false));
        c10.add(new Choice("Juan Baltazar", false));
        c10.add(new Choice("Kap. Elias Claudio", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("Ilang pantig mayroon ang bawat taludtod ng awit na Florante at Laura?");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("12", true));
        c11.add(new Choice("10", false));
        c11.add(new Choice("11", false));
        c11.add(new Choice("13", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("Sino ang asawa ni Francisco Balagtas?");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("Juana Tiambeng", true));
        c12.add(new Choice("Maria Asuncion Rivera", false));
        c12.add(new Choice("Magdalena Ana Ramos", false));
        c12.add(new Choice("Juana dela Cruz", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("Ano ang pamagat ng paglalagom na isinulat ni Lope K. Santos noong 1955 tungkol sa mga birtud ng Florante at Laura?");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("Ang Apat na Himagsik ni Francisco Balagtas", true));
        c13.add(new Choice("Ang Apat na Hinaing ni Francisco Balagtas", false));
        c13.add(new Choice("Ang Apat na Pakikidigma ni Francisco Balagtas", false));
        c13.add(new Choice("Ang Apat na Tinaliwas ni Francisco Balagtas", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("Sa edisyong Paculan ng Florante at Laura, alin sa mga ito ang ginamit na sanggunian ng editor?");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("Ronquillo, Cruz, Mabini, Gamboa-Mendoza", true));
        c14.add(new Choice("Cruz, Santos, Delos Santos, Ronquillo", false));
        c14.add(new Choice("Mabini, Delos Santos, Ronquillo, Gamboa-Mendoza", false));
        c14.add(new Choice("Gamboa-Mendoza, Delos Santos, Cruz, Ronquillo", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("Sa nobelang Noli Me Tangere ni Jose Rizal, may isang tauhan na nagsabing “Mahusay na makata at mahusay mag-isip si Baltazar.” Sino ang tauhang nagsabi nito?");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("Pilosopo Tasio", true));
        c15.add(new Choice("Elias", false));
        c15.add(new Choice("Crisostomo Ibarra", false));
        c15.add(new Choice("Padre Damaso", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("Ano ang tugmaan na makikita sa mga taludtod ng Florante at Laura?");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("AAAA", true));
        c16.add(new Choice("AABB", false));
        c16.add(new Choice("ABAB", false));
        c16.add(new Choice("ABCD", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("Bakit kailangang basahin ang obra ni Balagtas?");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("Ito ay isang simbolo ng kadakilaan ng mga Pilipino sa larangan ng pampanitikan", true));
        c17.add(new Choice("Isa itong paggalang sa dakilang mga likha ni Balagtas", false));
        c17.add(new Choice("Inidolo siya ni Jose Rizal kaya’t dapat din nating basahin ito", false));
        c17.add(new Choice("Pinalaya ng obrang ito ang mga Pilipino mula sa mga Espanyol", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("Sa kasalukuyan, ito ang mga nagkalat na edisyon ng Florante at Laura?");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("Edisyong Komersiyal", true));
        c18.add(new Choice("Edisyon ni Balagtas", false));
        c18.add(new Choice("Edisyon ni Mabini", false));
        c18.add(new Choice("Edisyon ni Ronquillo", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("Isa sa mga makapangyarihang ginamit na istratehiya sa awit ay ang _____.");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("Pagkukunwari", true));
        c19.add(new Choice("Paglalagay ng mga salitang basta tutugma sa isa’t isa", false));
        c19.add(new Choice("Pag-enggangyo sa mga prayle", false));
        c19.add(new Choice("Balagtasismo", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("Ano ang dahilan kung bakit ‘di na tapat sa edisyon ni Balagtas ang mga lumalabas na edisyon ng Florante at Laura ngayon?");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("Nawala na ang ilang parte ng akda", true));
        c20.add(new Choice("Nahulog sa dagat noong digmaan ang akda", false));
        c20.add(new Choice("Ibinaon ito sa lupa at ‘di na makita", false));
        c20.add(new Choice("Pinunit ng mga prayle ang akda", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat1.setQuestions(questions);

        return cat1;
    }

    private Category prepareCat2()
    {
        Category cat2 = new Category();
        cat2.setHasQuestions(true);
        cat2.setID(2);
        cat2.setTitle("KAY CELIA AT SA BABASA NITO");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("Sinabi ni Balagtas na iibigin niya si Celia hanggang sa siya’y?");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("Malibing", true));
        c1.add(new Choice("Masaksak", false));
        c1.add(new Choice("Masunog", false));
        c1.add(new Choice("Mahimatay", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("Sino si “Celia”?");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("Maria Asuncion Rivera", true));
        c2.add(new Choice("Maria Asuncion Romero", false));
        c2.add(new Choice("Maria Gamboa", false));
        c2.add(new Choice("Honeylhyn Asuncion", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("Ano ang ninais ni Balagtas noong iwan siya ni Celia?");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("Mamatay", true));
        c3.add(new Choice("Makalimot", false));
        c3.add(new Choice("Makatulog", false));
        c3.add(new Choice("Magmahal ng ibang babae", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("Ang mga sumusunod ay mga lugar na pinuntahan nila MALIBAN SA CORRECT ANSWER");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("Albania", true));
        c4.add(new Choice("Daungan ng mga barko", false));
        c4.add(new Choice("Makáting Ilog", false));
        c4.add(new Choice("Ilog Beata’t Hilom", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("Ano ang ninais ni Balagtas sa dulo ng “Kay Celia”?");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("Ipagdasal", true));
        c5.add(new Choice("Mahalin muli", false));
        c5.add(new Choice("Malasin", false));
        c5.add(new Choice("Mamatay na", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("Hiniling ni Balagtas sa “Babasa Nito” na");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("Huwag baguhin ang kaniyang akda", true));
        c6.add(new Choice("Huwag na basahin ito", false));
        c6.add(new Choice("Mahalin nila itong akda", false));
        c6.add(new Choice("Gayahin ang kaniyang mga yapak", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("Inamin ni Balagtas na ang kaniyang tula ay");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("May pagkukulang, ngunit may matututunan pa rin", true));
        c7.add(new Choice("May pagkukulang, ngunit wag bastusin", false));
        c7.add(new Choice("May pagkukulang, ngunit pinaghirapan niya ito", false));
        c7.add(new Choice("May pagkukulang, ngunit para ito sa mahal niya", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("Kapag mayroong hindi maintindihan sinabi ni Balagtas na");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("Tumingin sa mga talababa", true));
        c8.add(new Choice("Gumamit ng diksyunaryo", false));
        c8.add(new Choice("Magsaliksik sa internet", false));
        c8.add(new Choice("Basahin muli", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("Binanggit ni Balagtas na huwag daw matulad kay ______ sa pagsusulat dahil pabago-bago siya ng sinusulat.");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("Segismundo", true));
        c9.add(new Choice("Florante", false));
        c9.add(new Choice("Laura", false));
        c9.add(new Choice("Celia", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("Sa huling bahagi ng “Sa Babasa Nito” ay paano nagpaalam si Balagtas?");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("Nagbigay ng huling mga paalala", true));
        c10.add(new Choice("Nagkuwento siya", false));
        c10.add(new Choice("Inilarawan niya si Celia", false));
        c10.add(new Choice("Naglahad siya ng sariling mga karanasan", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("Hiniling ni Balagtas sa \"Babasa nito\" na HUWAG");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("Baguhin ang berso", true));
        c11.add(new Choice("Magdagdag ng berso", false));
        c11.add(new Choice("Intindihin ang sinasabi", false));
        c11.add(new Choice("Pagtawanan ang kaniyang sulat", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("Sa simula ng \"Sa Babasa Nito\" si Balagtas ay");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("Nagpasalamat", true));
        c12.add(new Choice("Nanghikayat", false));
        c12.add(new Choice("Nangimgbita", false));
        c12.add(new Choice("Tumula", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("Ayon kay Balagtas ang pabago-bago ng berso ay");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("Magpapa-alat sa isang akda", true));
        c13.add(new Choice("Magpapaganda sa tula", false));
        c13.add(new Choice("Magpapaintindi sa mambabasa", false));
        c13.add(new Choice("Magpapatulog sa mambabasa", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("Nangamba si Balagtas na si Celia ay");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("Makakalimot sa pag-iibigan", true));
        c14.add(new Choice("Makakatulog kay Balagtas", false));
        c14.add(new Choice("Makakalimot magluto ng almusal", false));
        c14.add(new Choice("Uuwi sa kaniyang nanay", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("Ang pang-aliw na ginagawa ni Balagtas ay");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("Pag-aalala sa mga pagsasama nila noon", true));
        c15.add(new Choice("Pagtingin sa litrato ni Celia", false));
        c15.add(new Choice("Pagpunta sa bahay ni Celia", false));
        c15.add(new Choice("Paglangoy sa dagat", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("Ano ang dumadalaw sa mga lugar na pinuntahan ni Balagtas at Celia dati?");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("Kaluluwa ni Balagtas", true));
        c16.add(new Choice("Si Balagtas mismo", false));
        c16.add(new Choice("Ang ama ni Balagtas", false));
        c16.add(new Choice("Paa ni Balagtas", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("Sino/ano ang umakay kay Balagtas para magsulat?");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("Pag-iwan sa kaniya ni Celia", true));
        c17.add(new Choice("Pagsasama nila ni Celia", false));
        c17.add(new Choice("Si Floresca", false));
        c17.add(new Choice("Ang kaniyang kasiyahan", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("Ang \"Kay Celia\", kung mailalapat sa panahon ngayon ay katulad ng awit na");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("'Di ko kayang tanggapin", true));
        c18.add(new Choice("Ang Huling El Bimbo", false));
        c18.add(new Choice("Buko", false));
        c18.add(new Choice("Harana", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("Ang Ninfas ay isang");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("Uri ng sirena", true));
        c19.add(new Choice("Anghel", false));
        c19.add(new Choice("Uri ng hayop", false));
        c19.add(new Choice("Bakulaw", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("Maaring gawing isang ______ ang tula ni balagtas");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("Awit", true));
        c20.add(new Choice("Sayaw", false));
        c20.add(new Choice("Komediya", false));
        c20.add(new Choice("Harana", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat2.setQuestions(questions);

        return cat2;
    }

    private Category prepareCat3()
    {
        Category cat3 = new Category();
        cat3.setHasQuestions(false);
        cat3.setID(3);
        cat3.setTitle("SA GITNA NG GUBAT AT PAGSINTA AT PANIBUGHO (SAK. 1-68)");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("", true));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("", true));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("", true));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("", true));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("", true));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("", true));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("", true));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("", true));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("", true));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("", true));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("", true));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("", true));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("", true));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("", true));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("", true));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("", true));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("", true));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("", true));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("", true));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("", true));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat3.setQuestions(questions);

        return cat3;
    }

    private Category prepareCat4()
    {
        Category cat4 = new Category();
        cat4.setHasQuestions(true);
        cat4.setID(4);
        cat4.setTitle("ANG GERERONG MORO (SAK. 69-104)");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("Ano ang isang Gererong Moro?");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("Mandirigmang Muslim", true));
        c1.add(new Choice("Tagabenta ng alahas", false));
        c1.add(new Choice("Naglilitis sa kaso ng mga mamayan", false));
        c1.add(new Choice("Isang uri ng doctor", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("Ano ang pinaka-unang isinigaw ng Gererong Moro?");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("“O Palad!”", true));
        c2.add(new Choice("“Ay Ama!”", false));
        c2.add(new Choice("“Di ko itutulot”", false));
        c2.add(new Choice("“Aray ko po!”", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("Ano ang suot-suot ng Gererong Moro sa kaniyang ulo?");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("Turbante", true));
        c3.add(new Choice("Kalubkob", false));
        c3.add(new Choice("Ulo ng Leon", false));
        c3.add(new Choice("Wala", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("Ayon sa Sak. 69, saan umano galing ang Gererong Moro?");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("Persya", true));
        c4.add(new Choice("Sparta", false));
        c4.add(new Choice("Atenas", false));
        c4.add(new Choice("Uzbekiztan", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("Si Gererong Moro ay naghihimutok tungkol saan?");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("Inagawan siya ng mahal", true));
        c5.add(new Choice("Namatay na ama", false));
        c5.add(new Choice("Nawawala siya sa gubat", false));
        c5.add(new Choice("Hindi niya mahanap ang kalasag niya", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("Bakit napatigil si Gererong moro sa kanyang paghihimutok?");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("May narinig siyang ibang tao sa gubat", true));
        c6.add(new Choice("Sumakit ang ulo niya", false));
        c6.add(new Choice("Naiihi siya", false));
        c6.add(new Choice("May leon sa harapan niya", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("Noong nakita si Gererong Moro ang baguntaong naka-gapos, ano ang ginagawa nito?");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("Naghihimutok tungkol sa namatay na ama", true));
        c7.add(new Choice("Tulog at naghihilik", false));
        c7.add(new Choice("Tawa nang tawa na para bang nababaliw na", false));
        c7.add(new Choice("Patay na", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("Ano ang ginamit na pampatay sa ama ng baguntao?");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("Kalis", true));
        c8.add(new Choice("Baril", false));
        c8.add(new Choice("Kanyon", false));
        c8.add(new Choice("Kamao", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("Saang parte ng katawan itinapat ang sadatang ginamit para ipampatay sa ama ng baguntao?");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("Leeg", true));
        c9.add(new Choice("Binti", false));
        c9.add(new Choice("Puso", false));
        c9.add(new Choice("Bituka", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("Ano ang ginawa sa kasintahan ng baguntao ayon sa himutok niya?");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("Inagaw mula sa baguntao", true));
        c10.add(new Choice("Binaril sa dibdib", false));
        c10.add(new Choice("Ikinulong", false));
        c10.add(new Choice("Ginawang alipin", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("Ano ang mga hawak ng Gererong Moro?");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("Kalasag at Sibat", true));
        c11.add(new Choice("Bomba at Espada", false));
        c11.add(new Choice("Dalawang Baril", false));
        c11.add(new Choice("Shuriken", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("Anong klaseng tikas raw ang mayroon ang gererong Moro?");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("Tikas ng Bayani", true));
        c12.add(new Choice("Tikas ng Leon", false));
        c12.add(new Choice("Tikas ng Matalino", false));
        c12.add(new Choice("Tikas ng Matanda", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("Sa anong direksyon tumingala ang gererong Moro?");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("Sa taas", true));
        c13.add(new Choice("Sa baba", false));
        c13.add(new Choice("Sa kanan", false));
        c13.add(new Choice("Sa Kaliwa", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("Saan unang umupo ang Gererong Moro?");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("Sa kahoy", true));
        c14.add(new Choice("Isang Bato", false));
        c14.add(new Choice("Patay na kabayo", false));
        c14.add(new Choice("Sa lupa", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("Ano ang ginagawa ng Gererong Moro noong una?");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("Naghahanap ng mapagpapahingaan", true));
        c15.add(new Choice("Naghahanap ng makakain", false));
        c15.add(new Choice("Naghahanap ng makakakuwentuhan", false));
        c15.add(new Choice("Naghahanap ng away", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("Ano ang pangalan ng iniibig ng Gererong Moro?");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("Flerida", true));
        c16.add(new Choice("Florida", false));
        c16.add(new Choice("Floyda", false));
        c16.add(new Choice("Floresna", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("Ano ang sinasabi ng Sak. 96?");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("Walang ibang makakapalit sa ama niya", true));
        c17.add(new Choice("Masakit magmahal", false));
        c17.add(new Choice("Pwede tayong magkaroon ng dalawang ama", false));
        c17.add(new Choice("Mahirap mag-ensayo pag kasama ang ama", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("Sa Saknong 98, Sa sobrang habang, ano raw ang muntik nang pumutok?");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("Dibdib", true));
        c18.add(new Choice("Tiyan", false));
        c18.add(new Choice("Puno", false));
        c18.add(new Choice("Baril", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("Sino raw ang umagaw sa iniibig ng Gererong Moro?");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("Konde Adolfo", true));
        c19.add(new Choice("Antenor", false));
        c19.add(new Choice("Kaniyang Ama", false));
        c19.add(new Choice("Kaniyang kapatid", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("Ano ang gustong gawin ng Gererong Moro sa kanyang Ama ngunit hindi niya kaya?");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("Patayin ito", true));
        c20.add(new Choice("Pabayaan ito", false));
        c20.add(new Choice("Itapon ito sa gubat", false));
        c20.add(new Choice("Kausapin ito", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat4.setQuestions(questions);

        return cat4;
    }

    private Category prepareCat5()
    {
        Category cat5 = new Category();
        cat5.setHasQuestions(false);
        cat5.setID(5);
        cat5.setTitle("PAGKALAG SA GAPOS AT NATURAL NA LEY (SAK. 105-170)");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("", true));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("", true));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("", true));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("", true));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("", true));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("", true));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("", true));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("", true));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("", true));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("", true));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("", true));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("", true));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("", true));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("", true));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("", true));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("", true));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("", true));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("", true));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("", true));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("", true));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat5.setQuestions(questions);

        return cat5;
    }

    private Category prepareCat6()
    {
        Category cat6 = new Category();
        cat6.setHasQuestions(true);
        cat6.setID(6);
        cat6.setTitle("PINAGMULAN AT PAGKAMULAT (SAK. 171-253)");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("Saan nagsimula ang kuwento ni Florante?");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("Pagkabata niya", true));
        c1.add(new Choice("Pag-aral niya sa Atenas", false));
        c1.add(new Choice("Buhay niya sa Albania", false));
        c1.add(new Choice("Pagkagapos niya sa gubat", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("Ang ama ni Florante ay si");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("Duke Briseo", true));
        c2.add(new Choice("Haring Linceo", false));
        c2.add(new Choice("Adolfo", false));
        c2.add(new Choice("Antenor", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("Ang pangalan ni Ina ni Florante ay si");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("Prinsesa Floresca", true));
        c3.add(new Choice("Laura", false));
        c3.add(new Choice("Esmeralda", false));
        c3.add(new Choice("Queen Amadufada", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("Ano ang hilig gawin ni Florante noong siya ay bata pa?");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("Mangaso sa gubat", true));
        c4.add(new Choice("Lumangoy sa dagat", false));
        c4.add(new Choice("Maghanap ng chicks", false));
        c4.add(new Choice("Matulog sa bahay", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("Noong nasa kinta si Florante ay may pumasok na buwitre sa kanilang bintana. Sino ang pumatay sa buwitre upang hindi masaktan si Florante?");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("Epiro", true));
        c5.add(new Choice("Duke Briseo", false));
        c5.add(new Choice("Prinsesa Floresca", false));
        c5.add(new Choice("Queen Arnuflosesca", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("Ano ang itinuro kay Florante ng kaniyang ama noong siya’y mas tumanda na?");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("Hindi maaaring mamuhay ng  walang hirap", true));
        c6.add(new Choice("Hindi siya puwede lumangoy", false));
        c6.add(new Choice("Bawal na siya mangaso", false));
        c6.add(new Choice("Hindi maaaring mamuhay ng walang armas", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("Saan ipinadala si Florante ng kaniyang ama upang siya’y matuto at maging mulat?");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("Sa Atenas", true));
        c7.add(new Choice("Sa Albania", false));
        c7.add(new Choice("Sa Crotona", false));
        c7.add(new Choice("Sa Mandaluyong", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("Mayroon nakilala si Florante sa lugar kung saan nag-aral si Florante na kababayan din pala niya. Isa siyang “maginoong” tao. Sino ito?");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("Si Adolfo", true));
        c8.add(new Choice("Si Minandro", false));
        c8.add(new Choice("Si Yocasta", false));
        c8.add(new Choice("Si Idipus Rex", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("Sino ang naging guro ni Florante noong siya’y ipinadala sa malayong lugar upang matuto, na siya rin ang naging amain ni Florante sa lugar na iyon?");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("Antenor", true));
        c9.add(new Choice("Minandro", false));
        c9.add(new Choice("Briseo", false));
        c9.add(new Choice("Adolfo", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("Bakit umiyak si Florante noong nakatanggap siya ng sulat mula sa kaniyang ama?");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("Dahil nabalitaan niyang yumao ang kaniyang ina", true));
        c10.add(new Choice("Dahil nabalitaan niyang iniwan na siya ng kaniyang kasintahan", false));
        c10.add(new Choice("Dahil nabalitaan niyang namatay na ang kaniyang ama", false));
        c10.add(new Choice("Dahil nabalitaan niyang nalunod sa dagat ang kaniyang aso", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("Sino ang nagtangkang pumatay kay Florante dahil sa inggit at poot?");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("Adolfo", true));
        c11.add(new Choice("Minandro", false));
        c11.add(new Choice("Haring Linceo", false));
        c11.add(new Choice("Ang mga Ninfas", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("Ano ang nadakip ng buwitre noong nakapasok ito sa bahay nila Florante?");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("Kuwintas ni Florante", true));
        c12.add(new Choice("Buhok ni Florante", false));
        c12.add(new Choice("Salawal ni Florante", false));
        c12.add(new Choice("Sapatos ni Florante", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("Ilang taon si Florante kung si Adolfo ay mas matanda ng 2 taon?");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("11", true));
        c13.add(new Choice("13", false));
        c13.add(new Choice("9", false));
        c13.add(new Choice("18", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("Ilang taon nag-aral si Florante sa Atenas?");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("6", true));
        c14.add(new Choice("5", false));
        c14.add(new Choice("4", false));
        c14.add(new Choice("7", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("Ilang sulat ang pinadala ng ama ni Florante sa kaniya?");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("2", true));
        c15.add(new Choice("3", false));
        c15.add(new Choice("1", false));
        c15.add(new Choice("4", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("Sa pangalawang sulat na pinadala ni Duke Briseo kay Florante ay iniutos niya na");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("Umuwi na siya sa Albania", true));
        c16.add(new Choice("Pagbutihin ang kaniyang pag-aral", false));
        c16.add(new Choice("Huwag na malunkgot", false));
        c16.add(new Choice("Papadalhan siya ng mga damit", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("Sino ang sumama kay Florante pabalik sa Albania?");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("Si Minandro", true));
        c17.add(new Choice("Si Antenor", false));
        c17.add(new Choice("Si Adolfo", false));
        c17.add(new Choice("Si Yocasta", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("Ano ang huling bilin ni Antenor bago umalis si Florante?");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("Huwag magpabaya at laging maging handa", true));
        c18.add(new Choice("Huwag na malungkot at maging masaya na", false));
        c18.add(new Choice("Maghiganti siya kay Adolfo pag-uwi niya", false));
        c18.add(new Choice("Bumisita muli siya sa Atenas", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("Ano ang ginawa ng mga mag-aaral ni Florante noong siya'y paalis na?");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("Umiyak sila", true));
        c19.add(new Choice("Nagpalakpakan sila", false));
        c19.add(new Choice("Lumangoy sila upang habulin ang daóng ni Florante", false));
        c19.add(new Choice("Yinakap nila si Florante", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("Alin sa mga sumusunod ang HINDI napag-aralan ni Florante sa Atenas?");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("Haynayan", true));
        c20.add(new Choice("Pilosopiya", false));
        c20.add(new Choice("Astrolohiya", false));
        c20.add(new Choice("Matematika", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat6.setQuestions(questions);

        return cat6;
    }

    private Category prepareCat7()
    {
        Category cat7 = new Category();
        cat7.setHasQuestions(true);
        cat7.setID(7);
        cat7.setTitle("DUGO AT DANGAL, SULYAP SA PAG-IBIG (SAK. 254-299)");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("Saan napadpad si Florante?");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("Albanya", true));
        c1.add(new Choice("Israel", false));
        c1.add(new Choice("Gresya", false));
        c1.add(new Choice("Ehipto", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("Saan agad-agad pumasok si Florante?");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("Kinta", true));
        c2.add(new Choice("Barko", false));
        c2.add(new Choice("Kawayang Bangka", false));
        c2.add(new Choice("Galleon", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("Sa Saknong 256, Ano ang ibig sabihin ng “humigit sa una ang dusang bumugso”?");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("Mas masakit ang nararamdaman ngayon", true));
        c3.add(new Choice("Mas mabilis nawawala ang sakit", false));
        c3.add(new Choice("Mas masakit ang naramdaman noon", false));
        c3.add(new Choice("Wala nang sakit", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("Galing sa anong lugar ang embahador na nakasaad sa Sak. 257?");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("Krotona", true));
        c4.add(new Choice("Tsina", false));
        c4.add(new Choice("Roma", false));
        c4.add(new Choice("Europa", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("Sino ang Heneral ni ibinanggit sa sulat na natanggap ni Duke Briseo?");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("Heneral Osmalik", true));
        c5.add(new Choice("Heneral Osvaldo", false));
        c5.add(new Choice("Heneral Oshimato", false));
        c5.add(new Choice("Heneral Obito", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("Sino ang tinaguriang kilabot ng mga gerero?");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("Aladin", true));
        c6.add(new Choice("Antenor", false));
        c6.add(new Choice("Aristotle", false));
        c6.add(new Choice("Amoscates", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("Sinong Hari ang nabanggit ni Duke Briseo sa pag-uusap nila ni Florante?");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("Haring Linceo", true));
        c7.add(new Choice("Haring Antenor", false));
        c7.add(new Choice("Haring Aladin", false));
        c7.add(new Choice("Haring Yocasta", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("Ano ang pangalan ng bayan na sinusubukang isalba ni Duke Briseo?");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("Krotona", true));
        c8.add(new Choice("Tsina", false));
        c8.add(new Choice("Albanya", false));
        c8.add(new Choice("Roma", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("Ayon sa Sak. 275, Sino ang diyosang may bituin?");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("Venus", true));
        c9.add(new Choice("Artemis", false));
        c9.add(new Choice("Neptune", false));
        c9.add(new Choice("Hera", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("Sino ang diyos ng pag-ibig?");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("Cupid", true));
        c10.add(new Choice("Hera", false));
        c10.add(new Choice("Zeus", false));
        c10.add(new Choice("Hermes", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("Sino ang ikinasisira ng isipan ni Florante?");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("Laura", true));
        c11.add(new Choice("Antenor", false));
        c11.add(new Choice("Gab", false));
        c11.add(new Choice("Flerida", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("Alin sa mga sumusunod ang diyos/a na hindi binanggit ni Florante?");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("Zeus", true));
        c12.add(new Choice("Venus", false));
        c12.add(new Choice("Cupid", false));
        c12.add(new Choice("Jupiter", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("Sino ang ama ni Laura?");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("Haring Linceo", true));
        c13.add(new Choice("Haring Antenor", false));
        c13.add(new Choice("Haring Briseo", false));
        c13.add(new Choice("Harin Pilato", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("Ano raw ang ginawa ni Laura kay Florante kaya’t naging masaklap ang buhay niya?");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("Pinagliluhan", true));
        c14.add(new Choice("Tinaga sa dibdib", false));
        c14.add(new Choice("Pinainom ng lason", false));
        c14.add(new Choice("Pinagluto", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("Sino ang sumakop sa bayan ng Krotona?");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("Moro", true));
        c15.add(new Choice("Asyano", false));
        c15.add(new Choice("Griyego", false));
        c15.add(new Choice("Romano", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("Sa Sakong 281, sino ang sinisi ni FLorante sa sakit na nararamdaman niya?");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("Haring Linceo", true));
        c16.add(new Choice("Duke Briseo", false));
        c16.add(new Choice("Konde Adolfo", false));
        c16.add(new Choice("Antenor", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("Ano ang ibig sabihin ng, “…kung anong taas ng pagkadakila, siya ring lagapak naman kung marapa”");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("Kung mas mataas ang posisyon, mas mataas ang inaasahan", true));
        c17.add(new Choice("Mas mataas ang takong ng mga sapatos ng Hari", false));
        c17.add(new Choice("Kailangan hindi madapa ang hari", false));
        c17.add(new Choice("Magiging hari si Florante", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("Ano ang HINDI nagyayari sa Sak. 292?");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("Nagpakasal sila bago sila umalis", true));
        c18.add(new Choice("Papunta na ang hukbo niya sa Krotona", false));
        c18.add(new Choice("Pinalad siyang makapanayam si Laura", false));
        c18.add(new Choice("Pinakita na mahal niya si Laura", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("Ano ang hinihiling ni Florante sa Sak. 298?");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("Huwag mahiwalay kay Laura", true));
        c19.add(new Choice("Magkaroon ng anak", false));
        c19.add(new Choice("Manalo sa labanan", false));
        c19.add(new Choice("Magpakasal na sana sila ni Laura", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("Ayon sa saknong 299, Ano raw ang ipinabaon kay Florante habang papunta siya sa Krotona?");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("Luha", true));
        c20.add(new Choice("Damit", false));
        c20.add(new Choice("Sapatos", false));
        c20.add(new Choice("Halik", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat7.setQuestions(questions);

        return cat7;
    }

    private Category prepareCat8()
    {
        Category cat8 = new Category();
        cat8.setHasQuestions(false);
        cat8.setID(8);
        cat8.setTitle("TAGUMPAY AT PAGLILILO (SAK. 300-346)");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("", true));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("", true));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("", true));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("", true));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("", true));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("", true));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("", true));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("", true));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("", true));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("", true));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("", true));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("", true));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("", true));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("", true));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("", true));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("", true));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("", true));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("", true));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("", true));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("", true));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat8.setQuestions(questions);

        return cat8;
    }

    private Category prepareCat9()
    {
        Category cat9 = new Category();
        cat9.setHasQuestions(false);
        cat9.setID(9);
        cat9.setTitle("MULING PAGTATAGPO AT MASAYANG WAKAS (SAK. 347-399)");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("", true));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        c1.add(new Choice("", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("", true));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        c2.add(new Choice("", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("", true));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        c3.add(new Choice("", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("", true));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        c4.add(new Choice("", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("", true));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        c5.add(new Choice("", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("", true));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        c6.add(new Choice("", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("", true));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        c7.add(new Choice("", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("", true));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        c8.add(new Choice("", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("", true));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        c9.add(new Choice("", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("", true));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        c10.add(new Choice("", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("", true));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        c11.add(new Choice("", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("", true));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        c12.add(new Choice("", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("", true));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        c13.add(new Choice("", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("", true));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        c14.add(new Choice("", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("", true));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        c15.add(new Choice("", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("", true));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        c16.add(new Choice("", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("", true));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        c17.add(new Choice("", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("", true));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        c18.add(new Choice("", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("", true));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        c19.add(new Choice("", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("", true));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        c20.add(new Choice("", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat9.setQuestions(questions);

        return cat9;
    }

    private Category prepareCat10()
    {
        Category cat10 = new Category();
        cat10.setHasQuestions(true);
        cat10.setID(10);
        cat10.setTitle("TALASALITAAN");

        List <Question> questions = new ArrayList<>();
        Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20;

        q1 = new Question("Nang mahuli ng mga pulis, <b>iginapos</b> nila ang mga kamay ng biktima gamit ang isang kadena.");
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("Itinali", true));
        c1.add(new Choice("Pinakawalan", false));
        c1.add(new Choice("Ikinulong", false));
        c1.add(new Choice("Pinutol", false));
        q1.setChoices(c1);
        questions.add(q1);

        q2 = new Question("Sapagkat siya ay lumaki sa pamilya ng mayayamang pulitiko, isa sa mga <b>pita</b> niya nang siya ay lumaki ay ang kapangyarihan.");
        List<Choice> c2 = new ArrayList<>();
        c2.add(new Choice("Matinding hangarin", true));
        c2.add(new Choice("Tinanggihang bagay", false));
        c2.add(new Choice("Kinahihiligan gawin", false));
        c2.add(new Choice("Sapilitang gawain", false));
        q2.setChoices(c2);
        questions.add(q2);

        q3 = new Question("Nagsigawan ang mga tao ng “<b>Viva</b>!” nang dumating ang hari.");
        List<Choice> c3 = new ArrayList<>();
        c3.add(new Choice("Mabuhay", true));
        c3.add(new Choice("Salamat", false));
        c3.add(new Choice("Walang Anuman", false));
        c3.add(new Choice("Lumayas ka", false));
        q3.setChoices(c3);
        questions.add(q3);

        q4 = new Question("<b>Pintakasi</b> ng Mataas na Paaralang Ateneo si San Estanislaw Kostka.");
        List<Choice> c4 = new ArrayList<>();
        c4.add(new Choice("Pinupuri", true));
        c4.add(new Choice("Iniidolo", false));
        c4.add(new Choice("Ginagaya", false));
        c4.add(new Choice("Inaayos", false));
        q4.setChoices(c4);
        questions.add(q4);

        q5 = new Question("Sumabog ang ulo ni Adolfo nang malamang naunahan na siya ni Florante. Anong tayutay ang makikita sa pangungusap?");
        List<Choice> c5 = new ArrayList<>();
        c5.add(new Choice("Pagmamalabis", true));
        c5.add(new Choice("Pagtutulad", false));
        c5.add(new Choice("Pagwawangis", false));
        c5.add(new Choice("Pagsasatao", false));
        q5.setChoices(c5);
        questions.add(q5);

        q6 = new Question("Nagsilbing sandata ng mandirigma ang kanyang <b>kalis</b> noong siya ay nasa gubat.");
        List<Choice> c6 = new ArrayList<>();
        c6.add(new Choice("Espada", true));
        c6.add(new Choice("Pana", false));
        c6.add(new Choice("Kutsilyo", false));
        c6.add(new Choice("Patalim", false));
        q6.setChoices(c6);
        questions.add(q6);

        q7 = new Question("Nagalit ang guro kay Adolfo dahil <b>nakaligtaan</b> niya ang gawaing-bahay.");
        List<Choice> c7 = new ArrayList<>();
        c7.add(new Choice("Nakalimutan", true));
        c7.add(new Choice("Naalala", false));
        c7.add(new Choice("Kinopya", false));
        c7.add(new Choice("Itinapon", false));
        q7.setChoices(c7);
        questions.add(q7);

        q8 = new Question("Malungkot at pakiramdam dahil <b>malamlam</b> ang sinag ng araw ngayon.");
        List<Choice> c8 = new ArrayList<>();
        c8.add(new Choice("Mahina", true));
        c8.add(new Choice("Malakas", false));
        c8.add(new Choice("Nagniningning", false));
        c8.add(new Choice("Namamatay", false));
        q8.setChoices(c8);
        questions.add(q8);

        q9 = new Question("Gumamit ng <b>palaso</b> ang mandirigma upang talunin ang kalaban. Alin sa mga sumusunod na paaralan ang may kaugnayan sa isang palaso?");
        List<Choice> c9 = new ArrayList<>();
        c9.add(new Choice("La Salle", true));
        c9.add(new Choice("Ateneo", false));
        c9.add(new Choice("UST", false));
        c9.add(new Choice("UP", false));
        q9.setChoices(c9);
        questions.add(q9);



        q10 = new Question("Nang kumalat ang buhok ng masayang araw, nagpasalamat ang marami. Aling tayutay ang makikita sa pangungusap na iyon?");
        List<Choice> c10 = new ArrayList<>();
        c10.add(new Choice("Pagsasatao", true));
        c10.add(new Choice("Pagtutulad", false));
        c10.add(new Choice("Onomatopeya", false));
        c10.add(new Choice("Pagmamalabis", false));
        q10.setChoices(c10);
        questions.add(q10);

        q11 = new Question("Ang <b>abang</b> nasa lansangan ay pinagtawanan ng mga dumaan.");
        List<Choice> c11 = new ArrayList<>();
        c11.add(new Choice("Mahirap", true));
        c11.add(new Choice("Mayaman", false));
        c11.add(new Choice("Malinis", false));
        c11.add(new Choice("Sakitin", false));
        q11.setChoices(c11);
        questions.add(q11);

        q12 = new Question("Natutuhan ko ang aking mga aralin mula sa aking napakagaling na <b>maestro</b> sa paaralan.");
        List<Choice> c12 = new ArrayList<>();
        c12.add(new Choice("Guro", true));
        c12.add(new Choice("Kaklase", false));
        c12.add(new Choice("Magulang", false));
        c12.add(new Choice("Kapatid", false));
        q12.setChoices(c12);
        questions.add(q12);

        q13 = new Question("Dahil siya ay may batang edad pa lang, maaaring masabing siya ay <b>kutad</b>.");
        List<Choice> c13 = new ArrayList<>();
        c13.add(new Choice("Birhen", true));
        c13.add(new Choice("Gamit na", false));
        c13.add(new Choice("Marumi", false));
        c13.add(new Choice("Masama", false));
        q13.setChoices(c13);
        questions.add(q13);

        q14 = new Question("Nangako si Tomas na pupunta siya sa pulong, ngunit ‘di siya dumating. Siya pa ang nagalit kinabukasan. Dahil dito, maaaring sabihing siya <b>lilo</b>.");
        List<Choice> c14 = new ArrayList<>();
        c14.add(new Choice("Walang utang na loob", true));
        c14.add(new Choice("Mabait", false));
        c14.add(new Choice("Matulungin", false));
        c14.add(new Choice("Pakialamero", false));
        q14.setChoices(c14);
        questions.add(q14);

        q15 = new Question("Dahil sobrang luwag ang nasuot na pantalon ni Leon, siya’y <b>nahubdan</b>. Alin sa mga sumusunod ang maaaring HINDI nangyari o mahinuha?");
        List<Choice> c15 = new ArrayList<>();
        c15.add(new Choice("Hindi madaling mahila ang kanyang pantalon", true));
        c15.add(new Choice("Nahubaran siya", false));
        c15.add(new Choice("Nawalan siya ng pambaba", false));
        c15.add(new Choice("Madaling mahila ang kanyang pambaba", false));
        q15.setChoices(c15);
        questions.add(q3);

        q16 = new Question("<b>Natititik</b> sa konstitusyon na sinumang kawaning may bagsak na grado ay liliban muna sa kanyang posisyon.");
        List<Choice> c16 = new ArrayList<>();
        c16.add(new Choice("Nakasulat", true));
        c16.add(new Choice("Inalis", false));
        c16.add(new Choice("Inalisan ng bisa", false));
        c16.add(new Choice("Binura", false));
        q16.setChoices(c16);
        questions.add(q16);

        q17 = new Question("Bago pa lamang si Briseo sa paaralan. Sa kanyang unang araw dito, siya <b>naumid</b>.");
        List<Choice> c17 = new ArrayList<>();
        c17.add(new Choice("Nahihiya", true));
        c17.add(new Choice("Walang hiya", false));
        c17.add(new Choice("Madaldal", false));
        c17.add(new Choice("Bulong nang bulong", false));
        q17.setChoices(c17);
        questions.add(q17);

        q18 = new Question("Si Florante ay isang <b>baguntao</b>. Ano ang range ng edad ng isang baguntao?");
        List<Choice> c18 = new ArrayList<>();
        c18.add(new Choice("8-14 taong gulang", true));
        c18.add(new Choice("0-7 taong gulang", false));
        c18.add(new Choice("15-18 taong gulang", false));
        c18.add(new Choice("19 pataas taong gulang", false));
        q18.setChoices(c18);
        questions.add(q18);

        q19 = new Question("Tila porselana ang kutis ni Celia. Anong tayutay ang makikita sa pangungusap?");
        List<Choice> c19 = new ArrayList<>();
        c19.add(new Choice("Pagtutulad", true));
        c19.add(new Choice("Pagwawangis", false));
        c19.add(new Choice("Pagsasatao", false));
        c19.add(new Choice("Pagmamalabis", false));
        q19.setChoices(c19);
        questions.add(q3);

        q20 = new Question("Dahil kumalat ang propesiya ni Edipo, siya <b>winakawak</b> at pinagbawalan munang bumalik sa kanyang lupang sinilangan.");
        List<Choice> c20 = new ArrayList<>();
        c20.add(new Choice("Ipinatapon sa malayong lugar", true));
        c20.add(new Choice("Kinulong sa isang kulungan", false));
        c20.add(new Choice("Pinaslang sa harap ng mga tao", false));
        c20.add(new Choice("Itinago sa gubat", false));
        q20.setChoices(c20);
        questions.add(q20);

        cat10.setQuestions(questions);

        return cat10;
    }

    /**
     * Makes a substring of a string bold.
     * @param text          Full text
     * @param textToBold    Text you want to make bold
     * @return              String with bold substring
     */

    public static SpannableStringBuilder makeSectionOfTextBold(String text, String textToBold){

        SpannableStringBuilder builder=new SpannableStringBuilder();

        if(textToBold.length() > 0 && !textToBold.trim().equals("")){

            //for counting start/end indexes
            String testText = text.toLowerCase(Locale.US);
            String testTextToBold = textToBold.toLowerCase(Locale.US);
            int startingIndex = testText.indexOf(testTextToBold);
            int endingIndex = startingIndex + testTextToBold.length();
            //for counting start/end indexes

            if(startingIndex < 0 || endingIndex <0){
                return builder.append(text);
            }
            else if(startingIndex >= 0 && endingIndex >=0){

                builder.append(text);
                builder.setSpan(new StyleSpan(Typeface.BOLD), startingIndex, endingIndex, 0);
            }
        }else{
            return builder.append(text);
        }

        return builder;
    }














}
