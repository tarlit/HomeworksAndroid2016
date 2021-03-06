package com.example.flowers;

public class Gardens {

    public static String[]names = new String[]{
            "Версай Градини (Франция)", "Cosmic Speculation (Шотландия)", "Boboli Gardens (Флоренция, Италия)",
            "Rikugien Gardens (Токио, Япония)", "Claude Monet's (Живерни, Франция)", "Butchart Gardens (Ванкувър, Канада)",
            "Kirstenbosch (Южна Африка)", " Yu Gardens (Шанхай, Китай)", "Exbury (Хемпшир, Великобритания)",
            "Keukenhof (Лисе, Холандия)", "Mirabell Garden (Залцбург, Австрия)"
    };

    public static int[] resourceIds = new int[]{
            R.drawable.versai_small, R.drawable.cosmic_speculation_small, R.drawable.boboli_small,
            R.drawable.rikugien_small, R.drawable.claude_monets_small, R.drawable.butchart_small,
            R.drawable.kirstenbosch_small, R.drawable.yu_gardens_small, R.drawable.exbury_small,
            R.drawable.keukenhof_small, R.drawable.mirabell_small
    };

    public static int[] picturesIds = new int[]{
            R.drawable.versai, R.drawable.cosmic_speculation, R.drawable.boboli,
            R.drawable.rikugien, R.drawable.claude_monets, R.drawable.butchart,
            R.drawable.kirstenbosch, R.drawable.yu_gardens, R.drawable.exbury,
            R.drawable.keukenhof, R.drawable.mirabell
    };


    public static String[] info = new String[]{
            "Една от най-известните градини в света е направена специално за Луи XIV от дизайнера Андре Ле Нотр. Във Версай всичко – форма, размер, цвят, растения, вода и скулптури, е изградено в определено съответствие, намерено е съвършеното съчетание за представяне на абсолютното. Паркът е симетрично изграден около основната ос изток – запад, свързана с пътя на слънцето и утвърждаването му като върховно митологично божество. Всичко е симетрично, дори да е изградено на няколко нива.",
            "Започната през 1970 г. в двора на семейството на Маги Кесуик, днес градината е поддържана от Чарлс Дженкс и съпругата му Луиса. Градината представлява уникалното търсене на човека в неговата мисия да разбере вселената. Тя е своеобразно свързване със същността на намиращото се извън границите на нашата вселена и пространство. Тук роля играят фундаменталните концепции на модерната физика като квантовата механика, теория за гравитацията, теория на комплексността и хаоса.",
            "Създадени зад двореца Пити във Флоренция. Boboli Gardens първоначално започват да се изграждат за Елеонора ди Толедо, съпруга на КосимоI деМедичи.Първите стъпки прави Николо Триболо, а в крайния етап на Буонталенти. Градините „Боболи” представляват парк, който служи като своеобразен “дом” на изчезнала колекция от скулптури. Градините впечатляват със своите широки чакълести алеи, каменни постройки, пищни статуи и фонтани, чувство за детайл. Всичко това се съчетание в пространства, буквално “населени” с нимфи, пещери и храмове.",
            "Rikugien Gardens означава “Градината на шестте поеми”. Интересното при нея е, че изобразява миниатюри на сценки от 88 известни поеми. Намира се в Токио и е една от най-красивите японски градини. Rikugien Gardens е създадена от Янагисауа Йошияцу с голямо, намиращо се в центъра езеро, малки острови, гористи местности, изкуствено направени хълмове и няколко традиционни японски къщи за чай.",
            "Това са градините на известния художник Клод Моне. Уникалното тук е, че са изобразени познати теми от най-добрите му картини като “Ад”, “Чистилище” и “Рай”. Градината е разположена в селцето Живерни, където Моне и семейството му се установяват през 1883 г. Художникът всъщност не харесвал организирането на градината. Това, което го впечатлява са самите цветове и красотата, която излъчват. Поради тази причина, той ги оставя да растат сами или както се изразява “на свобода”.",
            "Butchart Gardens (градините Бучард) се намират на остров Ванкувър, Канада. Те носят името Benvenuto, което на италиански означава “добре дошли”. Някога, използвани като парче земя, днес те са част от националното историческо наследство на Канада. Градините са собственост на наследниците на производителя на цимент от началото на 20-и век Робърт Пим Бучард и като част от традицията продължават да предлагат своето гостоприемство на всички желаещи да посетят това забележително място.",
            "Kirstenbosch Botanical Gardens се намират в Южна Африка. В тях виреят единствено местни растителни видове. Kirsten, което в последствие оформя и Kirstenbosch, което в превод означава “Гората на Кирстен”.Английската окупация от 1811 г. нанесла известни щети на парка. Върху част от земята били построени къщи на полковници от английската армия. Днес, тези постройки не съществуват, а градините са възвърнали естествения си вид.",
            "Красивите градини Yu Gardens на Шанхай са на възраст от 400 години. Те са аранжирани от династията Минг по време на императора Джия Джин и са възстановени през 1960 г. Като част от китайското историческо наследство, градините са считани за отражение на западно-китайския начин на озеленяване. Днес мястото е достъпно за туристи.",
            "Прекрасните градини Ексбъри се намират в графство Хемпшир. Ексбъри представляват 200 акра гориста местност с огромна колекция от рододендрони, азалии и камелии. Смятана е за най-красивия парк в Обединеното Кралство. Имението Ексбъри е закупено през 1919 г. от Лайънел Натан де Ротшилд. Днес паркът е отворен главно през пролетта и есента заради красивите цветове.В Ексбъри могат да се видят хортензии, каменна местност, черни лебеди, градината със слънчевия часовник, насята с екзотични растения, камелиите, които обграждат езерото и по малка пътека водят до река Bealieu.",
            "Градините „Кукенхоф”, познати още като „Градината на Европа”, се намират близо до холандското градче Лисе. Признати са за най-голямата цветна градина в света. Според официалния сайт на парка, всяка година в него се засаждат над 7 млн. луковици на лалета. „Кукенхоф” е отворен за посещения между последната седмица на март до средата на май всяка година.",
            "Световноизвестните градини на двореца „Мирабел” са част от крепостта „Хоензалцбург” и залцбургската катедрала. Автентичните градини са променени през 1689 г. от Йохан Бернхард Фишер фон Ерлах. През 1730 Франц Антон Данрайтър оформя това, което днес се смята за една от най-красивите барокови градини на Европа.На самите огради на градината могат да се видят статуи от 1689 г. изобразяващи римски богове. Огромен фонтан се издига в сърцето на парка. В „Мирабел” има още красива оранжерия, музей на Барока, бароков театър, бастион, розова долина."

    };

}
