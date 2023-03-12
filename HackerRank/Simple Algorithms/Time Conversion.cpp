
string timeConversion(string s) {
    int h, m, sec;
    string ampm;
    
    std::stringstream sstream(s);
    
    sstream >> h;
    sstream.ignore(1) >> m;
    sstream.ignore(1) >> sec >> ampm;
    
    if( h == 12 && (ampm.compare("AM") == 0) ){
        h = 0;
    }
    else if( ampm.compare("PM") == 0 ) {
        if(h != 12) {
            h += 12;
        }
    }
    
    std::ostringstream out;
    
    out << setw(2) << setfill('0') << h << ":" << setw(2) << setfill('0') << m << ":" << setw(2) << setfill('0') << sec;
    
    cout << out.str();
    
    return out.str();
}
