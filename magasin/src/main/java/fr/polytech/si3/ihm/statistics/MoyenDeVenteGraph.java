package fr.polytech.si3.ihm.statistics;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tanguy on 02/03/17.
 */
public class MoyenDeVenteGraph implements GenerateGraph {

    public void generateJavaScript() throws IOException {

        FileWriter jsFile1 = new FileWriter("highcharts1.js");

        jsFile1.write(

                "Highcharts.chart('container', {\n" +
                        "    chart: {\n" +
                        "        type: 'area'\n" +
                        "    },\n" +
                        "    title: {\n" +
                        "        text: 'Moyen de vente'\n" +
                        "    },\n" +
                        "    xAxis: {\n" +
                        "        categories: ['2009', '2010', '2011', '2012', '2013', '2014', '2015'],\n" +
                        "        tickmarkPlacement: 'on',\n" +
                        "        title: {\n" +
                        "            enabled: false\n" +
                        "        }\n" +
                        "    },\n" +
                        "    yAxis: {\n" +
                        "        title: {\n" +
                        "            text: 'Pourcentage'\n" +
                        "        }\n" +
                        "    },\n" +
                        "    tooltip: {\n" +
                        "        pointFormat: '<span style=\"color:{series.color}\">{series.name}</span>: <b>{point.percentage:.1f}%</b> ({point.y:,.0f} euros)<br/>',\n" +
                        "        split: true\n" +
                        "    },\n" +
                        "    plotOptions: {\n" +
                        "        area: {\n" +
                        "            stacking: 'percent',\n" +
                        "            lineColor: '#ffffff',\n" +
                        "            lineWidth: 1,\n" +
                        "            marker: {\n" +
                        "                lineWidth: 1,\n" +
                        "                lineColor: '#ffffff'\n" +
                        "            }\n" +
                        "        }\n" +
                        "    },\n" +
                        "    series: [{\n" +
                        "        name: 'Vente par internet avec livraison à domicile',\n" +
                        "        data: [106, 125, 150, 250, 267, 312, 350]\n" +
                        "    }, {\n" +
                        "        name: 'Vente par internet avec récupération de la commande en magasin',\n" +
                        "        data: [106, 125, 150, 250, 221, 250, 235]\n" +
                        "    }, {\n" +
                        "        name: 'Vente en magasin',\n" +
                        "        data: [406, 350, 364, 333, 302, 250, 232]\n" +
                        "    }]\n" +
                        "});"

        );

    }

}
