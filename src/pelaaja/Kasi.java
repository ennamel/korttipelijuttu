/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaaja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import korttipakka.Kortti;
import korttipakka.Korttipakka;
import korttipakka.Maa;

/**
 *
 * @author ile
 */
public class Kasi implements Comparable<Kasi> {

    private ArrayList<Kortti> kasi;
    private int koko;

    public Kasi() {

    }

    @Override
    public String toString() {
        String returni = "";
        for (Kortti kortti : kasi) {
            returni = returni + kortti + " ";
        }
        return returni;

    }

    public ArrayList<Kortti> returnKasiList() {
        return this.kasi;
    }

    public int[] getArvot() {
        int[] arvot = new int[kasi.size()];
        int i = 0;
        for (Kortti korttinen : kasi) {
            arvot[i] = korttinen.getArvo();
            i++;
        }
        return arvot;

    }

    public List<Integer> arvotAsList() {
        List<Integer> lista = new ArrayList<>();
        kasi.stream().forEach((korttinen) -> {
            lista.add(korttinen.getArvo());
        });
        return lista;
    }

    public ArrayList<Maa> getMaat() {
        ArrayList<Maa> maat = new ArrayList<>();
        kasi.stream().forEach((korttinen) -> {
            maat.add(korttinen.getMaa());
        });
        return maat;
    }

    public void jaaNelosetjaAssa(Korttipakka kp) {
        this.kasi.clear();
        kasi.add(new Kortti(Maa.HERTTA, 2));
        kasi.add(new Kortti(Maa.PATA, 2));
        kasi.add(new Kortti(Maa.RUUTU, 2));
        kasi.add(new Kortti(Maa.RISTI, 2));
        kasi.add(new Kortti(Maa.PATA, 14));
    }

    public void jaaTapari(Korttipakka kp) {
        this.kasi.clear();
        kasi.add(new Kortti(Maa.HERTTA, 2));
        kasi.add(new Kortti(Maa.PATA, 2));
        kasi.add(new Kortti(Maa.RUUTU, 2));
        kasi.add(new Kortti(Maa.RISTI, 3));
        kasi.add(new Kortti(Maa.PATA, 3));
    }

    @Override
    public int compareTo(Kasi tKasi) {
        kasiArvioija oma = new kasiArvioija(this);
        kasiArvioija vieras = new kasiArvioija(tKasi);
        int[] tama = oma.isPari();
        int[] tuo = vieras.isPari();

        //NELOSTEN TARKASTUS
        if (tama[5] == 4 && tuo[5] != 4) {
            return 1;
        } else if (tama[5] != 4 && tuo[5] == 4) {
            return -1;
        } else if (tama[5] == 4 && tuo[5] == 4) {
            if (tama[2] > tuo[2]) {
                return 1;
            } else if (tama[2] < tuo[2]) {
                return -1;
            } else if (tama[2] == tuo[2]) {
                return 0;
            }
        }

        //TÄPÄRIN TARKISTUS
        if (tama[5] == 1 && tuo[5] != 1 && tama[1] != -1 && tuo[1] != -1) {
            return 1;
        }
        if (tama[5] != 1 && tuo[5] == 1 && tama[1] != -1 && tuo[1] != -1) {
            return -1;
        }
        if (tama[5] == 1 && tuo[5] == 1 && tama[1] != -1 && tuo[1] != -1) {
            if (tama[0] > tuo[0]) {
                return 1;
            }
            if (tama[0] < tuo[0]) {
                return -1;
            }
            if (tama[0] == tuo[0]) {
                if (tama[1] > tuo[1]) {
                    return 1;
                }
                if (tama[1] < tuo[1]) {
                    return -1;
                }
                if (tama[1] == tuo[1]) {
                    return 1;
                }

            }

        }

        // KOLMOSTEN TARKISTUS
        if (tama[5] == 1 && tuo[5] != 1 && tama[1] == -1 && tuo[1] == -1) {
            return 1;
        }
        if (tama[5] != 1 && tuo[5] == 1 && tama[1] == -1 && tuo[1] == -1) {
            return -1;
        }
        if (tama[5] == 1 && tuo[5] == 1 && tama[1] == -1 && tuo[1] == -1) {
            if (tama[0] > tuo[0]) {
                return 1;
            }
            if (tama[0] < tuo[0]) {
                return -1;
            }
            if (tama[0] == tuo[0]) {
                if (tama[2] > tuo[2]) {
                    return 1;
                }
                if (tama[2] < tuo[2]) {
                    return -1;
                }
                if (tama[2] == tama[3]) {
                    if (tama[3] > tuo[3]) {
                        return 1;
                    }
                    if (tama[3] < tuo[3]) {
                        return -1;
                    }
                    if (tama[3] == tuo[3]) {
                        return 0;
                    }
                }

            }

        }

        //KAKSI PARIA TARKISTUS
        if (tama[1] != -1 && tuo[1] == -1) {
            return 1;
        }
        if (tama[1] == -1 && tuo[1] != -1) {
            return -1;
        }
        if (tama[1] != -1 && tuo[1] != -1) {
            if (tama[0] > tuo[0]) {
                return 1;
            }
            if (tama[0] < tuo[0]) {
                return -1;
            }
            if (tama[0] == tuo[0]) {
                if (tama[1] > tuo[1]) {
                    return 1;
                }
                if (tama[1] < tuo[1]) {
                    return -1;
                }
                if (tama[1] == tuo[1]) {
                    if (tama[2] > tuo[2]) {
                        return 1;
                    }
                    if (tama[2] < tuo[2]) {
                        return -1;
                    }
                    if (tama[2] == tuo[2]) {
                        return 0;
                    }
                }

            }

        }

        //PARI TARKISTUS
        if (tama[0] != -1 && tuo[0] == -1) {
            return 1;
        }
        if (tama[0] == -1 && tuo[0] != -1) {
            return -1;
        }
        if (tama[0] > tuo[0]) {
            return 1;
        }
        if (tama[0] < tuo[0]) {
            return 0;
        }
        if (tama[0] == tuo[0] && tama[0] != -1) {
            if (tama[2] > tuo[2]) {
                return 1;
            }
            if (tama[2] < tuo[2]) {
                return -1;
            }
            if (tama[2] == tuo[2]) {
                if (tama[3] > tuo[3]) {
                    return 1;
                }
                if (tama[3] < tuo[3]) {
                    return -1;
                }
                if (tama[3] == tuo[3]) {
                    if (tama[4] > tuo[4]) {
                        return 1;
                    }
                    if (tama[4] < tuo[4]) {
                        return -1;
                    }
                    if (tama[4] == tuo[4]) {
                        return 0;
                    }
                }

            }

        }

        //HIGH CARD TARKISTUS
        if (tama[0] == -1 && tuo[0] == -1) {

            List<Integer> nama = this.arvotAsList();
            List<Integer> nuo = tKasi.arvotAsList();

            Collections.sort(nama);
            Collections.sort(nuo);

            int laskuri = 1;

            for (int i = nama.size() - 1; i > -1; i++) {

                if (laskuri == 5) {
                    return 0;
                }

                if (nama.get(i) > nuo.get(i)) {
                    return 1;

                }

                if (nama.get(i) < nuo.get(i)) {
                    return -1;

                }
                laskuri++;

            }

        }

        return 0;
    }

    public void jaaKortteja(Korttipakka kp, int maara) {

        this.kasi = kp.arvoKortteja(maara);

    }

}
