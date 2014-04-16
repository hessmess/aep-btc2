package javamusic;

/**
 * Created by prabha on 2/21/14.
 */

import javax.sound.midi.*;

public class MyMusicCmdLine {
    public static void main(String [] args){
        MyMusicCmdLine mini = new MyMusicCmdLine();
        if (args.length <2 ){
            System.out.println("Dont forget the instrument and note args");
        }else{
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    }  //close main

    public void play(int instrument, int note){
        try{
            Sequencer player = MidiSystem.getSequencer();   //get a sequencer
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);  // make a new sequence

            Track track = seq.createTrack() ;      //get a new track from the sequence
//
//            ShortMessage first= new ShortMessage();
//            first.setMessage(192, 1, 102, 0);             // 192->change instrument command-->   to instrument 102
//            MidiEvent noteOn0 = new MidiEvent(first,1);
//            track.add(noteOn0);

            ShortMessage a= new ShortMessage();
            a.setMessage(144,1,44,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);                           //fill the track with Midi Events    144->note on, 128-> note off

            ShortMessage a1= new ShortMessage();
            a1.setMessage(144,2,20,100);
            MidiEvent noteOn1 = new MidiEvent(a1,1);
            track.add(noteOn1);

            ShortMessage b= new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);


            player.setSequence(seq);        //give the sequence to the sequencer

            player.start();
        }  catch(Exception ex){

            ex.printStackTrace();
        }

    }    //close play
}  //close class
